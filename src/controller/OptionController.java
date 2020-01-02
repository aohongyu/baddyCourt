package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

public class OptionController {

  @FXML private JFXTextField PlayerNameTextField;
  @FXML private MenuButton menuButton;
  @FXML private JFXTextField minTextField;
  @FXML private JFXTextField secTextField;
  @FXML private JFXButton timerPauseButton;
  private Scene previousScene;
  private CourtController courtController;
  static int SECOND;
  public boolean status = true;
  Timer timer = new Timer();
  TimerTask task =
      new TimerTask() {
        @Override
        public void run() {
          int mm = SECOND / 60 % 60;
          int ss = SECOND % 60;
          if (ss == 0) {
            ss = 60;
            mm -= 1;
          }
          if (SECOND == 0) {
            timer.cancel();
          }
          SECOND--;
          ss -= 1;

          // set timer text on court interface
          minTextField.setText(String.format("%02d", mm));
          secTextField.setText(String.format("%02d", ss));
        }
      };

  @FXML
  public void clickJoin() throws IOException {
    int currPlayerNum = PlayerManager.PLAYERNUM;
    Admin admin = StarterController.adminUser;
    PlayerManager playerManager = admin.getPlayerManager();
    String player = PlayerNameTextField.getText();
    String level = menuButton.getText();
    if (player.matches("[\\s]*")) {
      AlertController.failAlert("Please enter player's name.");
    } else if (level.equals("Please select level")) {
      AlertController.failAlert("Please select player's level.");
    } else {
      playerManager.addPlayer(player, level);
      // check if there is reenter player
      if (currPlayerNum != PlayerManager.PLAYERNUM - 1) {
        AlertController.failAlert(player + " has already in " + level + " group.");
      } else {
        AlertController.successAlert(player + " has been added to " + level + " group.");
        PlayerNameTextField.setText("");
        menuButton.setText("Please select level");
      }
      // update the number of current player
      courtController.setNumPlayers(PlayerManager.PLAYERNUM);
    }
  }

  @FXML
  public void clickLeave() throws IOException {
    int currPlayerNum = PlayerManager.PLAYERNUM;
    Admin admin = StarterController.adminUser;
    PlayerManager playerManager = admin.getPlayerManager();
    String player = PlayerNameTextField.getText();
    String level = menuButton.getText();
    if (player.matches("[\\s]*")) {
      AlertController.failAlert("Please enter player's name.");
    } else if (level.equals("Please select level")) {
      AlertController.failAlert("Please select player's level.");
    } else {
      playerManager.removePlayer(player, level);
      if (currPlayerNum != PlayerManager.PLAYERNUM + 1) {
        AlertController.failAlert(player + " is not in " + level + " group.");
      } else {
        AlertController.successAlert(player + " has been removed from " + level + " group.");
        PlayerNameTextField.setText("");
        menuButton.setText("Please select level");
      }
      courtController.setNumPlayers(PlayerManager.PLAYERNUM);
    }
  }

  public void clickTimerReset() throws IOException {
    minTextField.setText("");
    secTextField.setText("");
    SECOND = 0;
    this.timer.cancel();
    courtController.setTimerText("00:00");
    minTextField.setText(String.format("%02d", 0));
    secTextField.setText(String.format("%02d", 0));
  }

  public void clickTimerStart() throws IOException {
    // TODO: add alert: should reset first then start.
    int minutes = Integer.parseInt(minTextField.getText());
    int seconds = Integer.parseInt(secTextField.getText());
    SECOND = minutes * 60 + seconds;
    // TODO: 检查输入时间的有效性，无效时间pop up alert
    // courtController.setTimerText(minTextField.getText() + ":" + secTextField.getText());
    timer.scheduleAtFixedRate(task, 1000, 1000);
  }

  public void clickTimerPause() throws IOException {
    if (status) {
      this.timer.cancel();
      status = false;
      timerPauseButton.setText("Start");
    } else {
      this.timer = new Timer();
      this.task =
          new TimerTask() {
            @Override
            public void run() {
              int mm = SECOND / 60 % 60;
              int ss = SECOND % 60;
              if (ss == 0) {
                ss = 60;
                mm -= 1;
              }
              if (SECOND == 0) {
                timer.cancel();
              }
              SECOND--;
              ss -= 1;

              // set timer text on court interface
              minTextField.setText(String.format("%02d", mm));
              secTextField.setText(String.format("%02d", ss));
            }
          };
      timer.scheduleAtFixedRate(task, 1000, 1000);
      status = true;
      timerPauseButton.setText("Pause");
    }
  }

  public void setCourtController(CourtController courtController) {
    this.courtController = courtController;
  }

  @FXML
  void setUpLevel() {
    for (MenuItem menuItem : menuButton.getItems()) {
      menuItem.setOnAction(event -> menuButton.setText(menuItem.getText()));
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
