//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package mdi;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;
//import main.AppLaunchMain;
import model.PC;
import model.PCModels.*;
import utils.ControllerUtils;
import utils.ElementUtils;
import utils.FileReader;
import utils.model.Elements;

import static java.util.stream.Collectors.toList;
import static mdi.MainApp.globalStage;
//import static utils.ElementUtils.createTableView;

public class FXMLController implements Initializable {

    public ToolBar toolBar1;
    public ToolBar toolBar2;
    public TableView tableView;
    public MenuBar menuBar;
    public Button button;
    public MenuItem newFile;
    public MenuItem openFile;
    public MenuItem saveFile;
    public MenuItem saveAsFile;
    public MenuItem newWindow;
    public MenuItem createPc;
    public MenuItem deletePc;
    public MenuItem editPc;
    public MenuItem fileToolBar;
    public MenuItem pcToolBar;
    public Button newFileButton;
    public Button openFileButton;
    public Button saveFileButton;
    public Button saveAsFileButton;
    public Button newWindowFileButton;
    public Button newPcButton;
    public Button editPcButton;
    public Button deletePcButton;
    public ComboBox pcListComboBox;
    public ListView listView;
    public TableColumn firstDataColumn;
    public TableColumn secondDataColumn;
    private ElementUtils elementUtils;
    private Elements elements;
    private FileChooser fileChooser;

    @FXML
    private Label label;

    public FXMLController() {
    }

    public void initialize(URL url, ResourceBundle rb) {

        Image img1 = new Image(getClass().getResourceAsStream("/resources/floppy-2.png"), 30, 30, true, true);
        Image img2 = new Image(getClass().getResourceAsStream("/resources/open(1).jpg"), 30, 30, true, true);
        Image img3 = new Image(getClass().getResourceAsStream("/resources/edit.png"), 30, 30, true, true);
        Image img4 = new Image(getClass().getResourceAsStream("/resources/delete pc.png"), 30, 30, true, true);
        Image img5 = new Image(getClass().getResourceAsStream("/resources/new_window.png"), 30, 30, true, true);
        Image img6 = new Image(getClass().getResourceAsStream("/resources/create pc.png"), 30, 30, true, true);
        Image img7 = new Image(getClass().getResourceAsStream("/resources/new file.png"), 30, 30, true, true);
        Image img8 = new Image(getClass().getResourceAsStream("/resources/save as.png"), 30, 30, true, true);


//        saveFileButton = new Button();
//        openFileButton = new Button();
//        editPcButton = new Button();
//        deletePcButton = new Button();
//        newWindowFileButton = new Button();
//        newPcButton = new Button();
//        newFileButton = new Button();
//        saveAsFileButton = new Button();
//
//        saveFileButton.setGraphic(new ImageView(img1));
//        openFileButton.setGraphic(new ImageView(img2));
//        editPcButton.setGraphic(new ImageView(img3));
//        deletePcButton.setGraphic(new ImageView(img4));
//        newWindowFileButton.setGraphic(new ImageView(img5));
//        newPcButton.setGraphic(new ImageView(img6));
//        newFileButton.setGraphic(new ImageView(img7));
//        saveAsFileButton.setGraphic(new ImageView(img8));


        firstDataColumn.setCellValueFactory(new MapValueFactory(Elements.Column1MapKey));
        firstDataColumn.setMinWidth(250);
        secondDataColumn.setCellValueFactory(new MapValueFactory(Elements.Column2MapKey));
        secondDataColumn.setMinWidth(250);

        tableView.getSelectionModel().setCellSelectionEnabled(true);
        Callback<TableColumn<Map, String>, TableCell<Map, String>>
                cellFactoryForMap = p -> new TextFieldTableCell(new StringConverter() {
            @Override
            public String toString(Object t) {
                return t.toString();
            }

            @Override
            public Object fromString(String string) {
                return string;
            }
        });
        firstDataColumn.setCellFactory(cellFactoryForMap);
        secondDataColumn.setCellFactory(cellFactoryForMap);

//        tableView = createTableView();
        elementUtils = new ElementUtils();
        elements = new Elements();
        elementUtils.initPersonalComputerController(elements);
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Xml doc(*.xml)", "*.xml"));
        setOpenCreatePcDialog(createPc, elements.getPc(), false);
        setOpenCreatePcDialog(newPcButton, elements.getPc(), false);
//        initButtonActions(elements);
    }

    public void initialize() {
        elementUtils = new ElementUtils();
        elements = new Elements();
        elementUtils.initPersonalComputerController(elements);
//        initButtonActions(elements);
//        setActionsToMenuItems();
    }

//    private void initButtonActions(Elements elements) {
//        setOpenCreatePcDialog(elements.getMenuEdit().getItems().get(0), elements.getPc(), false);
//        setOpenCreatePcDialog(elements.getCreateFile(), elements.getPc(), false);
//        setActionToListOfPc();
//        setActionToSaveButton();
////        setActionToLoadButton();
//        setClearAction();
//    }

    @FXML
    public void handleHideFileToolBar() {
        if (toolBar1.isVisible()) {
            toolBar1.setVisible(false);
        } else {
            toolBar1.setVisible(true);
        }
    }

    @FXML
    public void handleHidePcToolBar() {
        if (toolBar2.isVisible()) {
            toolBar2.setVisible(false);
        } else {
            toolBar2.setVisible(true);
        }
    }

    private void setOpenCreatePcDialog(MenuItem item, PC pc, boolean switcher) {
        initAction(elements.getNewCpu(), pc.getCpu(), switcher);
        initAction(elements.getNewMotherboard(), pc.getMotherboard(), switcher);
        initAction(elements.getNewGraphicCard(), pc.getGraphicCard(), switcher);
        initAction(elements.getNewRam(), pc.getRam(), switcher);
        item.setOnAction(event -> {
            Elements.getGridPane().setEffect(new GaussianBlur());
            final Stage dialog = new Stage(StageStyle.TRANSPARENT);
            VBox dialogVbox = new VBox(20);
            dialogVbox.setAlignment(Pos.CENTER);
            dialogVbox.setPadding(new Insets(35, 20 ,10, 20));

            Button cancel = new Button("cancel");
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(elements.getPrimaryStage());
            dialog.setScene(new Scene(dialogVbox, 300, 750));
            cancel.setOnAction(e -> {
                Elements.getGridPane().setEffect(null);
                dialog.hide();
            });
            dialogVbox.getChildren().addAll(elements.getNewCpu(),
                    elements.getNewRam(),
                    elements.getNewGraphicCard(),
                    elements.getNewMotherboard(),
                    elements.getPcNameLabel(),
                    elements.getPcName(),
                    elements.getPowerSupplyLabel(),
                    elements.getPowerSupplierSpinner(),
                    elements.getPriceLabel(),
                    elements.getPriceSpinner(),
                    elements.getHddLabel(),
                    elements.getHddSpinner(),
                    Elements.submitPc,
                    elements.getSaveToFileCheckBox(),
                    cancel);

            if (switcher) {
                elements.getPcName().setText(pc.getPcName());
                elements.getHddSpinner().getValueFactory().setValue(pc.getHddSize());
                elements.getPriceSpinner().getValueFactory().setValue(pc.getPrice().intValue());
                elements.getPowerSupplierSpinner().getValueFactory().setValue(pc.getPowerSupplier());
            }

            dialog.show();
            submitSaveAction(Elements.submitPc, pc, dialog);
        });
    }

    private void setOpenCreatePcDialog(Button button, PC pc, boolean switcher) {
        initAction(elements.getNewCpu(), pc.getCpu(), switcher);
        initAction(elements.getNewMotherboard(), pc.getMotherboard(), switcher);
        initAction(elements.getNewGraphicCard(), pc.getGraphicCard(), switcher);
        initAction(elements.getNewRam(), pc.getRam(), switcher);

        Button cancel = new Button("cancel");

        button.setOnAction(event -> {
            Elements.getGridPane().setEffect(new GaussianBlur());
            final Stage dialog = new Stage(StageStyle.TRANSPARENT);
            VBox dialogVbox = new VBox(20);
            dialogVbox.setAlignment(Pos.CENTER);
            dialogVbox.setPadding(new Insets(60, 20 ,0, 20));

            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(elements.getPrimaryStage());
            dialog.setScene(new Scene(dialogVbox, 300, 750));
            dialogVbox.getChildren().addAll(elements.getNewCpu(),
                    elements.getNewRam(),
                    elements.getNewGraphicCard(),
                    elements.getNewMotherboard(),
                    elements.getPcNameLabel(),
                    elements.getPcName(),
                    elements.getPowerSupplyLabel(),
                    elements.getPowerSupplierSpinner(),
                    elements.getPriceLabel(),
                    elements.getPriceSpinner(),
                    elements.getHddLabel(),
                    elements.getHddSpinner(),
                    Elements.submitPc,
                    elements.getSaveToFileCheckBox(),
                    cancel);

            if (switcher) {
                elements.getPcName().setText(pc.getPcName());
                elements.getHddSpinner().getValueFactory().setValue(pc.getHddSize());
                elements.getPriceSpinner().getValueFactory().setValue(pc.getPrice().intValue());
                elements.getPowerSupplierSpinner().getValueFactory().setValue(pc.getPowerSupplier());
            }

            cancel.setOnAction(e -> {
                Elements.getGridPane().setEffect(null);
                dialog.hide();
            });

            dialog.show();
            submitSaveAction(Elements.submitPc, pc, dialog);
        });
    }

    private void setOpenEditPcDialog(MenuItem item, PC pc) {
        setOpenCreatePcDialog(item, pc, true);
    }

    private void setOpenEditPcDialog(Button button, PC pc) {
        setOpenCreatePcDialog(button, pc, true);
    }

    private void initAction(Button button, PCPart pcPart, boolean switcher) {
        button.setOnAction(event -> {
            Button cancel = new Button("cancel");

            Elements.getGridPane().setEffect(new GaussianBlur());
            final Stage dialog = new Stage(StageStyle.TRANSPARENT);
            VBox dialogVbox = new VBox(20);
            dialogVbox.setAlignment(Pos.CENTER);
            dialogVbox.setPadding(new Insets(10, 20 ,10, 20));

            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(elements.getPrimaryStage());
            dialog.setScene(new Scene(dialogVbox, 300, 300));

            cancel.setOnAction(e -> {
                Elements.getGridPane().setEffect(null);
                dialog.hide();
            });

            dialogVbox.getChildren().addAll(elements.getListOfEnums(), elements.getModelField(), elements.getAdditionalInfoField(), Elements.submit, elements.getLabel(), cancel);

            if (switcher) {
                elements.getListOfEnums().getSelectionModel().select(pcPart.getProducerEnum());
                elements.getModelField().setText(pcPart.getModel());
                elements.getAdditionalInfoField().setText(pcPart.getAddInfo());
            }
            dialog.show();
            submitSaveAction(Elements.submit, pcPart, dialog);
        });
    }

    private void submitSaveAction(Button button, PCPart pcPart, Stage dialog) {
        button.setOnAction(event1 -> {
            elements.getLabel().setText("");
            if (ControllerUtils.isNotEmpty(elements.getModelField(), elements.getAdditionalInfoField()) &&
                    elements.getListOfEnums().getSelectionModel().getSelectedItem() != null) {
                pcPart.setProducerEnum(ProducerEnum.valueOf(elements.getListOfEnums().getSelectionModel().getSelectedItem().toString().toUpperCase()));
                pcPart.setModel(elements.getModelField().getText().toUpperCase());
                pcPart.setAddInfo(elements.getAdditionalInfoField().getText().toUpperCase());
                elements.getLabel().setText("Submission successful");
                setPcPartToMainObject(pcPart);
//                dialog.close();
                dialog.hide();
                clean(Arrays.asList(elements.getModelField(), elements.getAdditionalInfoField()));
            } else {
                clean(Arrays.asList(elements.getModelField(), elements.getAdditionalInfoField()));
                elements.getLabel().setText("Not Enough values for submission");
            }
        });
    }

    private void submitSaveAction(Button button, PC pc, Stage dialog) {
        button.setOnAction(event1 -> {
            elements.getLabelPc().setText("");
            if (ControllerUtils.isNotEmpty(elements.getPcName()) && elements.getPriceSpinner().getValue() != null
                    && elements.getHddSpinner().getValue() != null
                    && elements.getPowerSupplierSpinner().getValue() != null) {

                pc.setHddSize(elements.getHddSpinner().getValue());
                pc.setPcName(elements.getPcName().getText());
                pc.setPrice(Double.valueOf(elements.getPriceSpinner().getValue()));
                pc.setPowerSupplier(elements.getPowerSupplierSpinner().getValue());
                elements.getLabelPc().setText("Submission successful");
                dialog.close();
                Elements.getGridPane().setEffect(null);
                if (pcListComboBox.getSelectionModel().getSelectedItem() != null) {
                    tableView.setItems(getPcMap(getPcByPcName(pcListComboBox.getSelectionModel().getSelectedItem().toString())));

                } else {
                    tableView.setItems(getPcMap(pc));
                    ElementUtils.addObjectToListOfPc(elements, pc, pcListComboBox);
                }
                PC pcToRemove = elements.getComputers().stream().filter(element -> element.getPcName().equalsIgnoreCase(pc.getPcName())).findFirst().orElse(null);
                if (pcToRemove != null) {
                    elements.getComputers().remove(pcToRemove);
                    elements.getComputers().add(pc);
                    elements.getPcs().setPcs(elements.getComputers());
                }
                if (elements.getSaveToFileCheckBox().isSelected()) {
                    FileReader.save(elements.getPcs(), elements.getFile());
                    tableView.setItems(getPcMap(getPcByPcName(pcListComboBox.getSelectionModel().getSelectedItem().toString())));
                }
            } else {
                elements.getLabelPc().setText("Not Enough values for submission");
            }
        });
    }

    private void setActionToSaveButton() {
        elements.getSaveFile().setOnAction(event -> {
            if (!elements.getComputers().isEmpty()) {
                elements.getPcs().setPcs(elements.getComputers());
            }
            if (elements.getPcs() != null && elements.getFile() != null && !elements.getPcs().getPcs().isEmpty() ) {
                FileReader.save(elements.getPcs(), elements.getFile());
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Missing file!");
                alert.setHeaderText("Please specify target file");
                alert.showAndWait();
            }
        });
    }

    @FXML
    private void setActionToListOfPc() {
        pcListComboBox.setOnAction(event -> {
            if (pcListComboBox.getSelectionModel().getSelectedItem() != null) {
                PC localPc = getPcByPcName(pcListComboBox.getSelectionModel().getSelectedItem().toString());
                tableView.setItems(getPcMap(localPc));
                tableView.refresh();
                tableView.getItems().forEach(System.out::println);
                setOpenEditPcDialog(editPc, localPc);
                setOpenEditPcDialog(editPcButton, localPc);
            }
        });

    }

    private PC getPcByPcName(final String name) {
        return elements.getComputers().stream().filter(pc -> name.equalsIgnoreCase(pc.getPcName())).findFirst().get();
    }

    private void setPcPartToMainObject(PCPart pcPart) {
        if (pcPart instanceof Cpu) {
            elements.getPc().setCpu((Cpu) pcPart);
        } else if (pcPart instanceof GraphicCard) {
            elements.getPc().setGraphicCard((GraphicCard) pcPart);
        } else if (pcPart instanceof Motherboard) {
            elements.getPc().setMotherboard((Motherboard) pcPart);
        } else elements.getPc().setRam((Ram) pcPart);
    }

    private ObservableList<Map> getPcMap(PC pc) {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        List<String> listOfParams = getListOFFields();
        List<String> listOfValues = getListOfValues(pc);
        for (int i = 0; i < 16; i++) {
            Map map = new HashMap<>();
            map.put(Elements.Column1MapKey, listOfParams.get(i));
            map.put(Elements.Column2MapKey, listOfValues.get(i));
            allData.add(map);
        }

        return allData;
    }

    private void setClearAction() {
        elements.getClear().setOnAction(event -> {
            elements.setComputers(new ArrayList<>());
            elements.getPcs().setPcs(new ArrayList<>());
            elements.setPc(new PC());
            listView.setItems(FXCollections.observableArrayList());
            listView.refresh();
            pcListComboBox.setItems(FXCollections.observableArrayList());
            tableView.setItems(FXCollections.observableArrayList());
        });
    }

    private void setActionsToMenuItems() {

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Xml doc(*.xml)", "*.xml"));

        elements.getNewFile().setOnAction(this::handleCreateFileAction);
        elements.getMenuFile().getItems().get(0).setOnAction(this::handleCreateFileAction);

        //Add action to open file
        elements.getMenuFile().getItems().get(1).setOnAction(this::handleOpenFileAction);

        //Add action to save file
        elements.getMenuFile().getItems().get(2).setOnAction(this::handleSaveFileAction);

        elements.getMenuFile().getItems().get(3).setOnAction(this::handleSaveAsFileAction);
        elements.getSaveAsFile().setOnAction(this::handleSaveAsFileAction);
        //Add action to open new window
        //Add action to delete pc
        elements.getMenuEdit().getItems().get(2).setOnAction(this::handleDeleteElementAction);

        elements.getOpenFile().setOnAction(this::handleOpenFileAction);

        elements.getMenuView().getItems().get(0).setOnAction(event -> {
            if (elements.getFileToolBar().isVisible()) {
                elements.getFileToolBar().setVisible(false);
                elements.getEditToolBar().setVisible(false);
            } else {
                elements.getFileToolBar().setVisible(true);
                elements.getEditToolBar().setVisible(true);
            }
        });

    }

    private boolean isXmlType(File file) {
        String filename = file.getName();
        String fileExtension = filename.substring(filename.indexOf('.') + 1, filename.length());

        if (!fileExtension.equals("xml")) {
            return false;
        }

        return true;
    }

    private List<String> getListOfValues(PC pc) {
        return Arrays.asList(
                pc.getPcName(),
                pc.getCpu().getProducerEnum().getProducer(),
                pc.getCpu().getModel(),
                pc.getCpu().getAddInfo(),
                pc.getMotherboard().getProducerEnum().getProducer(),
                pc.getMotherboard().getModel(),
                pc.getMotherboard().getAddInfo(),
                pc.getGraphicCard().getProducerEnum().getProducer(),
                pc.getGraphicCard().getModel(),
                pc.getGraphicCard().getAddInfo(),
                pc.getRam().getProducerEnum().getProducer(),
                pc.getRam().getModel(),
                pc.getRam().getAddInfo(),
                String.valueOf(pc.getHddSize()),
                String.valueOf(pc.getPowerSupplier()),
                String.valueOf(pc.getPrice())
        );
    }

    private List<String> getListOFFields() {
        return Arrays.asList(
                "Pc name",
                "CPU producer",
                "CPU java.model",
                "CPU addInfo",
                "MotherBoard producer",
                "MotherBoard java.model",
                "MotherBoard addInfo",
                "GraphicCard producer",
                "GraphicCard java.model",
                "GraphicCard addInfo",
                "RAM producer",
                "RAM java.model",
                "RAM addInfo",
                "hddSize",
                "powerSupplier",
                "price"
        );
    }

    @FXML
    private void handleCreateFileAction(ActionEvent event) {
        // Button was clicked, change color
        fileChooser.setTitle("Create file");
        File file = fileChooser.showSaveDialog(globalStage);
        try {
            Alert alert;
            if (file != null && file.createNewFile()) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful file creation");
                alert.setHeaderText("File successfully created!");
                alert.showAndWait();
                elements.setFile(file);
            } else {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Unsuccessful file creation");
                alert.setHeaderText("File wasn't created!");
            }
        } catch (IOException ex) {
        }
    }

    @FXML
    private void handleOpenFileAction(ActionEvent event) {
        // Button was clicked, change color
        fileChooser.setTitle("Open file");
        File file = fileChooser.showOpenDialog(globalStage);
        if (file != null && isXmlType(file)) {
            elements.setFile(file);
            elements.setComputers(FileReader.loadFile(file));
            if (elements.getComputers() != null) {
                pcListComboBox.setItems(FXCollections.observableArrayList(elements.getComputers().stream().map(PC::getPcName).collect(toList())));
            }

        } else if (file != null && !isXmlType(file)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Wrong file");
            alert.setContentText("The selected file is not of type .xml!");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleSaveFileAction(ActionEvent event) {
        if (elements.getFile() != null) {
            elements.getPcs().setPcs(elements.getComputers());
            FileReader.save(elements.getPcs(), elements.getFile());
        } else {
            fileChooser.setTitle("Save file");
            File file = fileChooser.showSaveDialog(globalStage);
            if(file != null) {
                elements.setFile(file);
                elements.getPcs().setPcs(elements.getComputers());
                FileReader.save(elements.getPcs(), elements.getFile());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Missing file!");
                alert.setHeaderText("Target file is missing!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleSaveAsFileAction(ActionEvent event) {
        fileChooser.setTitle("Save file as");
        File file = fileChooser.showSaveDialog(globalStage);

        if (file != null) {
            elements.getPcs().setPcs(elements.getComputers());
            FileReader.save(elements.getPcs(), file);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing file!");
            alert.setHeaderText("Target file is missing!");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeleteElementAction(ActionEvent event) {
        // Button was clicked, change color
        PC pcByPcName = getPcByPcName(pcListComboBox.getSelectionModel().getSelectedItem().toString());
        elements.getComputers().remove(pcByPcName);
        pcListComboBox.setItems(FXCollections.observableArrayList(elements.getComputers().stream().map(PC::getPcName).collect(toList())));
        tableView.setItems(FXCollections.observableList(new ArrayList<>()));
    }

    private static void clean(List<TextField> list) {
        list.forEach(TextInputControl::clear);
    }
}
