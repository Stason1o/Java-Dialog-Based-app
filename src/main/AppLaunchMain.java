package main;

import controller.PersonalComputerController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.PCScene;
import utils.model.Elements;


public class AppLaunchMain extends Application {

    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        startApp(primaryStage);
    }

    public static void startApp(Stage primaryStage) {
        mainStage = primaryStage;
        PersonalComputerController computerController = new PersonalComputerController();
        computerController.initialize();

        Scene pcScene = new PCScene(Elements.getGridPane(), 500, 400);
        primaryStage.setTitle("PC Maintenance");
        primaryStage.setScene(pcScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
