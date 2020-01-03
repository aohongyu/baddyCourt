package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;
import controller.*;

public class Main extends Application {

  public static void main(String[] args) {
    Application.launch();
    System.exit(0);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    Admin admin = new Admin();
    admin.initializeSystem();

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
    AnchorPane starterPane = fxmlLoader.load();
    StarterController starterController = fxmlLoader.getController();
    StarterController.setAdmin(admin);

    // connect starter scene and court scene
    FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/view/CourtStatus.fxml"));
    AnchorPane courtPane = fxmlLoader1.load();
    Scene courtScene = new Scene(courtPane);
    starterController.setCourtScene(courtScene);
    CourtController courtController = fxmlLoader1.getController();
    starterController.setCourtController(courtController);
    Scene scene = new Scene(starterPane);
    // set the previous scene
    courtController.setPreviousScene(scene);

    // connect court scene and option scene
    FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/view/Option.fxml"));
    AnchorPane optionPane = fxmlLoader2.load();
    Scene optionScene = new Scene(optionPane);
    courtController.setOptionScene(optionScene);
    OptionController optionController = fxmlLoader2.getController();
    optionController.setCourtController(courtController);
    courtController.setOptionController(optionController);
    // set the previous scene
    optionController.setPreviousScene(courtScene);


    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setResizable(false);
  }
}
