package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

public class OptionController {

  public static CourtController courtController;
  @FXML private JFXTextField PlayerNameTextField;
  @FXML private MenuButton menuButton;
  @FXML private JFXTextField minTextField;
  @FXML private JFXTextField secTextField;
  @FXML private JFXButton timerPauseButton;
  private Scene previousScene;
//  private CourtController courtController;
  static int SECOND;
  public boolean pauseStatus = false;
  public boolean startStatus = false;
  static int DEFALUTMIN;
  static int DEFALUTSEC;
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

          SECOND--;
          ss -= 1;

          // set timer text on option interface
          minTextField.setText(String.format("%02d", mm));
          secTextField.setText(String.format("%02d", ss));

          if (SECOND == 0) {
            timer.cancel();
            minTextField.setText(String.format("%02d", 0));
            secTextField.setText(String.format("%02d", 0));
            Platform.runLater(()-> {
              try {
                AlertController.courtChangeAlert("Time's up. Time to change court :)");
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
          }
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
    SECOND = 0;
    if (startStatus) {
      this.timer.cancel();
      timerPauseButton.setText("Pause");
    }

    if (pauseStatus) {
      timerPauseButton.setText("Pause");
    }

    minTextField.setText(String.format("%02d", DEFALUTMIN));
    secTextField.setText(String.format("%02d", DEFALUTSEC));
    pauseStatus = false;
    startStatus = false;

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

            SECOND--;
            ss -= 1;

            // set timer text on option interface
            minTextField.setText(String.format("%02d", mm));
            secTextField.setText(String.format("%02d", ss));

            if (SECOND == 0) {
              timer.cancel();
              minTextField.setText(String.format("%02d", 0));
              secTextField.setText(String.format("%02d", 0));
              Platform.runLater(()-> {
                try {
                  AlertController.courtChangeAlert("Time's up. Time to change court :)");
                } catch (IOException e) {
                  e.printStackTrace();
                }
              });
            }
          }
        };
  }

  public void clickTimerStart() throws IOException {
    // should reset first then start.
    if (startStatus) {
      AlertController.failAlert("The timer is now running. Please stop or reset the timer first.");
    } else {
      if (pauseStatus) {
        AlertController.failAlert("The timer is now paused. Please use resume button.");
      } else {
        DEFALUTMIN = Integer.parseInt(minTextField.getText());
        DEFALUTSEC = Integer.parseInt(secTextField.getText());
        String startMin = minTextField.getText();
        String startSec = secTextField.getText();
        // check format of time
        if ((startMin.matches("00") && startSec.matches("[0-5][1-9]")) ||
            (startMin.matches("([0-9][1-9]|[1-9][0-9])") && startSec.matches("[0-5][0-9]")) ||
            (startMin.matches("00") && startSec.matches("10"))) {
          int minutes = DEFALUTMIN;
          int seconds = DEFALUTSEC;
          SECOND = minutes * 60 + seconds;
          timer.scheduleAtFixedRate(task, 1000, 1000);
          startStatus = true;
          timerPauseButton.setText("Pause");
        } else {
          AlertController.failAlert("Please enter valid time.");
        }
      }
    }
  }

  public void clickTimerPause() throws IOException {
    if ((!startStatus && timerPauseButton.getText().equals("Pause"))) {
      AlertController.failAlert("The timer is now paused.");
    } else {
      if (startStatus) {
        this.timer.cancel();
        startStatus = false;
        pauseStatus = true;
        timerPauseButton.setText("Resume");
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

                SECOND--;
                ss -= 1;

                // set timer text on option interface
                minTextField.setText(String.format("%02d", mm));
                secTextField.setText(String.format("%02d", ss));

                if (SECOND == 0) {
                  timer.cancel();
                  minTextField.setText(String.format("%02d", 0));
                  secTextField.setText(String.format("%02d", 0));
                  Platform.runLater(()-> {
                    try {
                      AlertController.courtChangeAlert("Time's up. Time to change court :)");
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
                  });
                }
              }
            };
        timer.scheduleAtFixedRate(task, 1000, 1000);
        startStatus = true;
        pauseStatus = false;
        timerPauseButton.setText("Pause");
      }
    }
  }

  public void setCourtController(CourtController courtController) {
    this.courtController = courtController;
  }

  public CourtController getCourtController() {
    return courtController;
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
