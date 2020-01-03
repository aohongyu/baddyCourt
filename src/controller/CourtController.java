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
  public static OptionController optionController;
//  private OptionController optionController;
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
  @FXML private Label timerTextField;

  Admin admin = StarterController.adminUser;
  CourtManager courtManager = admin.getCourtManager();

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
    if (CourtManager.COURTNUM == 3) {
      if (PlayerManager.PLAYERNUM < 12) {
        AlertController.failAlert("There is not enough players.");
      } else if (PlayerManager.ADVNUM < 4 || PlayerManager.INTNUM < 4) {
        if (PlayerManager.ADVNUM < 4) {
          AlertController.failAlert("Sorry, in this version, we cannot execute court change. \n"
              + "Since there is not enough advanced players.");
        } else {
          AlertController.failAlert("Sorry, in this version, we cannot execute court change. \n"
              + "Since there is not enough intermediate players.");
        }
      } else {
        courtManager.setUp3Court();
        Object[] playerList1 = (Object[]) courtManager.courtStatus.get(1);
        c1a.setText(String.valueOf(playerList1[0]));
        c1b.setText(String.valueOf(playerList1[1]));
        c1c.setText(String.valueOf(playerList1[2]));
        c1d.setText(String.valueOf(playerList1[3]));
        Object[] playerList2 = (Object[]) courtManager.courtStatus.get(2);
        c2a.setText(String.valueOf(playerList2[0]));
        c2b.setText(String.valueOf(playerList2[1]));
        c2c.setText(String.valueOf(playerList2[2]));
        c2d.setText(String.valueOf(playerList2[3]));
        Object[] playerList3 = (Object[]) courtManager.courtStatus.get(3);
        c3a.setText(String.valueOf(playerList3[0]));
        c3b.setText(String.valueOf(playerList3[1]));
        c3c.setText(String.valueOf(playerList3[2]));
        c3d.setText(String.valueOf(playerList3[3]));
      }
    } else if (CourtManager.COURTNUM == 6) {
      if (PlayerManager.PLAYERNUM < 24) {
        AlertController.failAlert("There is not enough players.");
      } else if (PlayerManager.ADVNUM < 4 || PlayerManager.INTNUM < 4) {
        if (PlayerManager.ADVNUM < 4) {
          AlertController.failAlert("Sorry, in this version, we cannot execute court change. \n"
              + "Since there is not enough advanced players.");
        } else {
          AlertController.failAlert("Sorry, in this version, we cannot execute court change. \n"
              + "Since there is not enough intermediate players.");
        }
      } else {
        courtManager.setUp6Court();
        Object[] playerList1 = (Object[]) courtManager.courtStatus.get(1);
        c1a.setText(String.valueOf(playerList1[0]));
        c1b.setText(String.valueOf(playerList1[1]));
        c1c.setText(String.valueOf(playerList1[2]));
        c1d.setText(String.valueOf(playerList1[3]));
        Object[] playerList2 = (Object[]) courtManager.courtStatus.get(2);
        c2a.setText(String.valueOf(playerList2[0]));
        c2b.setText(String.valueOf(playerList2[1]));
        c2c.setText(String.valueOf(playerList2[2]));
        c2d.setText(String.valueOf(playerList2[3]));
        Object[] playerList3 = (Object[]) courtManager.courtStatus.get(3);
        c3a.setText(String.valueOf(playerList3[0]));
        c3b.setText(String.valueOf(playerList3[1]));
        c3c.setText(String.valueOf(playerList3[2]));
        c3d.setText(String.valueOf(playerList3[3]));
        Object[] playerList4 = (Object[]) courtManager.courtStatus.get(4);
        c4a.setText(String.valueOf(playerList4[0]));
        c4b.setText(String.valueOf(playerList4[1]));
        c4c.setText(String.valueOf(playerList4[2]));
        c4d.setText(String.valueOf(playerList4[3]));
        Object[] playerList5 = (Object[]) courtManager.courtStatus.get(5);
        c5a.setText(String.valueOf(playerList5[0]));
        c5b.setText(String.valueOf(playerList5[1]));
        c5c.setText(String.valueOf(playerList5[2]));
        c5d.setText(String.valueOf(playerList5[3]));
        Object[] playerList6 = (Object[]) courtManager.courtStatus.get(6);
        c6a.setText(String.valueOf(playerList6[0]));
        c6b.setText(String.valueOf(playerList6[1]));
        c6c.setText(String.valueOf(playerList6[2]));
        c6d.setText(String.valueOf(playerList6[3]));
      }
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
