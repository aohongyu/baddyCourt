package controller;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
  private Scene previousScene;

  @FXML
  public void clickJoin() throws IOException {
    Admin admin = StarterController.adminUser;
    PlayerManager playerManager = admin.getPlayerManager();
    String player = PlayerNameTextField.getText();
    String level = menuButton.getText();
    if (player.matches("[\\s]*")) {
      AlertController.failAlert("Please enter player's name.");
    } else if (level.equals("Please select level")) {
      AlertController.failAlert("Please select player's level.");
    } else {
      Player badmintonPlayer;
      badmintonPlayer = new Player(player, level);
      playerManager.addPlayer(badmintonPlayer, level);
      AlertController.successAlert(player + " has been added to " + level + " group.");
      PlayerNameTextField.setText("");
      menuButton.setText("Please select level");
    }
    // test
    System.out.println("total: " + playerManager.getTotalNumPlayers());
    System.out.println("b: " + playerManager.getNumBeginner());
    System.out.println("i: " + playerManager.getNumIntermediate());
    System.out.println("a: " + playerManager.getNumAdvance());
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
