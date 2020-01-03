package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AlertController {

  @FXML private Label alertLabel;
  CourtController courtController;
  OptionController optionController;

  @FXML
  public void clickGotIt(MouseEvent mouseEvent) {
    Stage s = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    s.hide();
  }

  @FXML
  public void clickCourtChangeCancel(MouseEvent mouseEvent) throws IOException {
    Stage s = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    s.hide();
    optionController = CourtController.optionController;
    optionController.clickTimerReset();
  }

  @FXML
  public void clickOnCourtChange(MouseEvent mouseEvent) throws IOException {
    Stage s = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    s.hide();
    courtController = OptionController.courtController;
    courtController.clickCourtChange();
    optionController = CourtController.optionController;
    optionController.clickTimerReset();
  }

  void setAlertLabel(String alert) {
    alertLabel.setText(alert);
  }

  public static void successAlert(String alert) throws IOException {
    FXMLLoader fxmlLoader =
        new FXMLLoader(AlertController.class.getResource("/view/SuccessAlert.fxml"));
    showScene(fxmlLoader, alert);
  }

  public static void failAlert(String alert) throws IOException {
    FXMLLoader fxmlLoader =
        new FXMLLoader(AlertController.class.getResource("/view/FailAlert.fxml"));
    showScene(fxmlLoader, alert);
  }

  public static void courtChangeAlert(String alert) throws IOException {
    FXMLLoader fxmlLoader =
        new FXMLLoader(AlertController.class.getResource("/view/CourtChangeAlert.fxml"));
    showScene(fxmlLoader, alert);
  }

  private static void showScene(FXMLLoader fxmlLoader, String alert) throws IOException {
    AnchorPane alertPane = fxmlLoader.load();
    AlertController alertController = fxmlLoader.getController();
    alertController.setAlertLabel(alert);
    Scene scene = new Scene(alertPane);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }
}
