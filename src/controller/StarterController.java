package controller;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

public class StarterController {

  private CourtController courtController;
  private Scene courtScene;
  static Admin adminUser;
  @FXML private JFXTextField StartTimeTextField;
  @FXML private JFXTextField EndTimeTextField;
  @FXML private JFXTextField CourtNumTextField;

  public static void setAdmin(Admin admin){
    adminUser = admin;
  }

  @FXML
  public void clickStart(MouseEvent mouseEvent) throws IOException {
    String startTime = StartTimeTextField.getText();
    String endTime = EndTimeTextField.getText();
    String courtNum = CourtNumTextField.getText();
    Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    if (!startTime.matches("([01][0-9]|2[0-3]):[0-5][0-9]")
        || !endTime.matches("([01][0-9]|2[0-3]):[0-5][0-9]")) {
      AlertController.failAlert("Please enter valid time.");
    } else if (!courtNum.matches("[1-6]")) {
      AlertController.failAlert("Please enter valid number of courts.");
    } else {
      stage.setScene(courtScene);
      courtController.setStartTime(startTime);
      courtController.setEndTime(endTime);
      courtController.setNumPlayers(PlayerManager.PLAYERNUM);
    }
  }

  public void setCourtController(CourtController courtController) {
    this.courtController = courtController;
  }

  public void setCourtScene(Scene courtScene) {
    this.courtScene = courtScene;
  }
}
