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
  private CourtController courtController;

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
      playerManager.addPlayer(player, level);
      AlertController.successAlert(player + " has been added to " + level + " group.");
      PlayerNameTextField.setText("");
      menuButton.setText("Please select level");
      // update the number of current player
      courtController.setNumPlayers(PlayerManager.PLAYERNUM);
    }
    // TODO: ##################################TEST#################################################
    System.out.println("total: " + PlayerManager.PLAYERNUM);
    System.out.println("b: " + playerManager.getNumBeginner());
    System.out.println("i: " + playerManager.getNumIntermediate());
    System.out.println("a: " + playerManager.getNumAdvance());
    // TODO: ##################################TEST#################################################
  }

  @FXML
  public void clickLeave() throws IOException {
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
      courtController.setNumPlayers(PlayerManager.PLAYERNUM);
      AlertController.successAlert(player + " has been removed from " + level + " group.");
      PlayerNameTextField.setText("");
      menuButton.setText("Please select level");
    }
    // test
    System.out.println("total: " + PlayerManager.PLAYERNUM);
    System.out.println("b: " + playerManager.getNumBeginner());
    System.out.println("i: " + playerManager.getNumIntermediate());
    System.out.println("a: " + playerManager.getNumAdvance());
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
