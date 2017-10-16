import controller.PersonalComputerController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.*;
import utils.model.Elements;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        PersonalComputerController computerController = new PersonalComputerController();
        computerController.initialize();

        Scene pcScene = new PCScene(Elements.getGridPane(), 500, 300);
        primaryStage.setTitle("PC Maintenance");
        primaryStage.setScene(pcScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
