package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

public class CourtController {

  private Scene optionScene;
  private Scene previousScene;
  private OptionController optionController;
  @FXML private Label startTime;
  @FXML private Label endTime;
  @FXML private Label numPlayers;
  @FXML private Label c1a;
  @FXML private Label c1b;
  @FXML private Label c1c;
  @FXML private Label c1d;
  @FXML private Label c2a;
  @FXML private Label c2b;
  @FXML private Label c2c;
  @FXML private Label c2d;
  @FXML private Label c3a;
  @FXML private Label c3b;
  @FXML private Label c3c;
  @FXML private Label c3d;
  @FXML private Label c4a;
  @FXML private Label c4b;
  @FXML private Label c4c;
  @FXML private Label c4d;
  @FXML private Label c5a;
  @FXML private Label c5b;
  @FXML private Label c5c;
  @FXML private Label c5d;
  @FXML private Label c6a;
  @FXML private Label c6b;
  @FXML private Label c6c;
  @FXML private Label c6d;

  public void setStartTime(String start) {
    startTime.setText(start);
  }

  public void setEndTime(String end) {
    endTime.setText(end);
  }

  public void setNumPlayers(int players) {
    numPlayers.setText(String.valueOf(players));
  }

  public void setOptionController(OptionController optionController) {
    this.optionController = optionController;
  }

  public void setOptionScene(Scene optionScene) {
    this.optionScene = optionScene;
  }

  public void clickOption(MouseEvent mouseEvent) throws IOException {
    Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    optionController.setUpLevel();
    stage.setScene(optionScene);
  }

  public void clickCourtChange() throws IOException {
    Admin admin = StarterController.adminUser;
    CourtManager courtManager = admin.getCourtManager();
    if (CourtManager.COURTNUM == 1) {
      courtManager.setUp1Court();
      String[] playerList = (String[]) courtManager.courtStatus.get(1);
      c1a.setText(playerList[0]);
      c1b.setText(playerList[1]);
      c1c.setText(playerList[2]);
      c1d.setText(playerList[3]);
    }
  }

  public void setPreviousScene(Scene scene) {
    previousScene = scene;
  }

  @FXML
  public void clickBack(MouseEvent mouseEvent) {
    Stage s = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    s.setScene(previousScene);
    s.show();
  }
}
