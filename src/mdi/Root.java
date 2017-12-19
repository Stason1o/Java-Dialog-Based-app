package mdi;

import controller.PersonalComputerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Root {
    public MenuItem newFile;
    public MenuItem openFile;
    public MenuItem saveFile;
    public MenuItem saveAsFile;
    public MenuItem createPc;
    public MenuItem editPc;
    public MenuItem deletePc;
    public MenuItem fileToolBar;
    public MenuItem pcToolBar;
    public ToolBar toolBar1;
    public Button newFileButton;
    public Button openFileButton;
    public Button saveFileButton;
    public Button saveAsFileButton;
    public MenuBar menuBar;
    FXMLController fxmlController = new FXMLController();
    PersonalComputerController computerController = new PersonalComputerController();

    {
        computerController.initialize();
//        fxmlController.initialize();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        this.label.setText("Hello World!");
    }

    public Root() {
    }

    @FXML
    private Label label;

    public void initialize(URL url, ResourceBundle rb) {//        fxmlController = new FXMLController();

    }

//    @FXML
//    private void handleCreateFileAction() {
//        newFile.setOnAction(fxmlController::handleCreateFileAction);
//    }
//
//    @FXML
//    public void handleOpenFileAction() {
//        openFile.setOnAction(fxmlController::handleOpenFileAction);
//    }
//
//    @FXML
//    public void handleSaveFileAction() {
//        saveFile.setOnAction(fxmlController::handleSaveFileAction);
//    }
//
//    @FXML
//    public void handleSaveAsFileAction() {
//        saveAsFile.setOnAction(fxmlController::handleSaveAsFileAction);
//    }
//
//    @FXML
//    private void handleCreateFileActionButton() {
//        System.out.println(newFileButton);
//        System.out.println(fxmlController);
//        newFileButton.setOnAction(fxmlController::handleCreateFileAction);
//    }
//
//    @FXML
//    public void handleOpenFileActionButton() {
//        openFileButton.setOnAction(fxmlController::handleOpenFileAction);
//    }
//
//    @FXML
//    public void handleSaveFileActionButton() {
//        saveFileButton.setOnAction(fxmlController::handleSaveFileAction);
//    }
//
//    @FXML
//    public void handleSaveAsFileActionButton() {
//        saveAsFileButton.setOnAction(fxmlController::handleSaveAsFileAction);
//    }
//
//    @FXML
//    public void handleFileToolBar(ActionEvent actionEvent) {
//        if(fileToolBar.isVisible()){
//            fileToolBar.setVisible(false);
//        } else {
//            fileToolBar.setVisible(true);
//        }
//    }
//
//    @FXML
//    public void handlePcToolBar(ActionEvent actionEvent) {
//        if(pcToolBar.isVisible()){
//            pcToolBar.setVisible(false);
//        } else {
//            pcToolBar.setVisible(true);
//        }
//    }
}
