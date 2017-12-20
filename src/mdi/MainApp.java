//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package mdi;

import java.util.logging.Level;
import java.util.logging.Logger;

//import controller.PersonalComputerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.model.Elements;

public class MainApp extends Application {
    public static Stage globalStage;
    int i = 0;

    public MainApp() {
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/mdi/root.fxml"));


        globalStage = stage;
        for(int i = 0; i < ((AnchorPane)root).getChildren().size(); ++i) {
            ((AnchorPane)root).getChildren().remove(i);
        }

        MDICanvas canvas = new MDICanvas();
        canvas.setPrefHeight(50000.0D);
        Button createNewWindow = new Button("Create New Window");
        createNewWindow.setOnAction((event) -> {
            try {
//                PersonalComputerController computerController = new PersonalComputerController();
//                computerController.initialize();
                MDIWindow dIWindow = new MDIWindow("" + this.i, new ImageView(), "Tilte 1", FXMLLoader.load(this.getClass().getResource("/mdi/Scene.fxml")));
                canvas.addMDIWindow(dIWindow);
            } catch (Exception var4) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, var4);
            }

            ++this.i;
        });
        VBox box = new VBox(new Node[]{createNewWindow,FXMLLoader.load(this.getClass().getResource("/mdi/root.fxml")), canvas});
        AnchorPane.setBottomAnchor(box, 0.0D);
        AnchorPane.setTopAnchor(box, 0.0D);
        AnchorPane.setLeftAnchor(box, 0.0D);
        AnchorPane.setRightAnchor(box, 0.0D);
        ((AnchorPane)root).getChildren().add(box);
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
