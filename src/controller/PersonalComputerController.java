package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.AppLaunchMain;
import model.PCModels.*;
import scenes.PCScene;
import utils.ElementUtils;
import utils.FileReader;
import utils.functionalinterface.EventListenerInterface;
import utils.model.Elements;

import model.PC;
import utils.ControllerUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by sbogdanschi on 9/13/2017.
 */
public class PersonalComputerController {

    private ElementUtils elementUtils;
    private Elements elements;
    private final FileChooser fileChooser = new FileChooser();

    public void initialize() {
        elementUtils = new ElementUtils();
        elements = new Elements();
        elementUtils.initPersonalComputerController(elements);
        initButtonActions(elements);
        setActionsToMenuItems();
    }

    private void initButtonActions(Elements elements) {
        setOpenCreatePcDialog(elements.getMenuEdit().getItems().get(0), elements.getPc(), false);
        setOpenCreatePcDialog(elements.getCreateFile(), elements.getPc(), false);
        setActionToListOfPc();
        setActionToSaveButton();
//        setActionToLoadButton();
        setClearAction();
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
            dialog.setScene(new Scene(dialogVbox, 300, 650));
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
            dialogVbox.setPadding(new Insets(35, 20 ,10, 20));

            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(elements.getPrimaryStage());
            dialog.setScene(new Scene(dialogVbox, 300, 650));
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
                System.out.println(pcPart.getProducerEnum());
                System.out.println(pcPart.getModel());
                System.out.println(pcPart.getAddInfo());
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
                System.out.println(pcPart);
                System.out.println(elements.getPc());
            } else {
                System.out.println("Clear");
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
                System.out.println("SAVED ACTION");
                dialog.close();
                Elements.getGridPane().setEffect(null);
                if (elements.getListOfPcNames().getSelectionModel().getSelectedItem() != null) {
                    elements.getTable().setItems(getPcMap(getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString())));

                } else {
                    elements.getTable().setItems(getPcMap(pc));
                    ElementUtils.addObjectToListOfPc(elements, pc);
                }
                PC pcToRemove = elements.getComputers().stream().filter(element -> element.getPcName().equalsIgnoreCase(pc.getPcName())).findFirst().orElse(null);
                if (pcToRemove != null) {
                    elements.getComputers().remove(pcToRemove);
                    elements.getComputers().add(pc);
                    elements.getPcs().setPcs(elements.getComputers());
                }
                if (elements.getSaveToFileCheckBox().isSelected()) {
                    FileReader.save(elements.getPcs(), elements.getFile());
                    elements.getTable().setItems(getPcMap(getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString())));
                }
            } else {
                System.out.println("Clear");
                elements.getLabelPc().setText("Not Enough values for submission");
            }
        });
    }

    private void setActionToSaveButton() {
        elements.getSaveFile().setOnAction(event -> {
            if (!elements.getComputers().isEmpty()) {
                elements.getPcs().setPcs(elements.getComputers());
            }
            if (!elements.getPcs().getPcs().isEmpty()) {
                FileReader.save(elements.getPcs(), elements.getFile());
            }
        });
    }

    private void setActionToListOfPc() {
        if (elements.getListOfPcNames() != null) {
            elements.getListOfPcNames().setOnAction(event -> {
                if (elements.getListOfPcNames().getSelectionModel().getSelectedItem() != null) {
                    PC localPc = getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString());
                    elements.getTable().setItems(getPcMap(localPc));
                    setOpenEditPcDialog(elements.getMenuEdit().getItems().get(1), localPc);
                    setOpenEditPcDialog(elements.getEditFile(), localPc);
                }
            });
        }
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
            elements.getViewElements().setItems(FXCollections.observableArrayList());
            elements.getViewElements().refresh();
            elements.getListOfPcNames().setItems(FXCollections.observableArrayList());
            elements.getTable().setItems(FXCollections.observableArrayList());
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
        elements.getMenuFile().getItems().get(4).setOnAction(this::handleNewWindowAction);
        elements.getNewWindow().setOnAction(this::handleNewWindowAction);
        //Add action to delete pc
        elements.getMenuEdit().getItems().get(2).setOnAction(this::handleDeleteElementAction);

        elements.getOpenFile().setOnAction(this::handleOpenFileAction);

        elements.getMenuView().getItems().get(0).setOnAction(event -> {
            if (elements.getToolBar().isVisible()) {
                elements.getToolBar().setVisible(false);
            } else {
                elements.getToolBar().setVisible(true);
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

    private void handleCreateFileAction(ActionEvent event) {
        // Button was clicked, change color
        fileChooser.setTitle("Create file");
        File file = fileChooser.showSaveDialog(elements.getPrimaryStage());
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
            System.out.println(ex.getMessage());
        }
    }

    private void handleOpenFileAction(ActionEvent event) {
        // Button was clicked, change color
        fileChooser.setTitle("Open file");
        File file = fileChooser.showOpenDialog(elements.getPrimaryStage());
        if (file != null && isXmlType(file)) {
            elements.setFile(file);
            elements.setComputers(FileReader.loadFile(file));
            if (elements.getComputers() != null) {
                elements.getListOfPcNames().setItems(FXCollections.observableArrayList(elements.getComputers().stream().map(PC::getPcName).collect(toList())));
            }

        } else if (file != null && !isXmlType(file)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Wrong file");
            alert.setContentText("The selected file is not of type .xml!");

            alert.showAndWait();
        }
    }

    private void handleSaveFileAction(ActionEvent event) {
        if (elements.getFile() != null) {
            elements.getPcs().setPcs(elements.getComputers());
            FileReader.save(elements.getPcs(), elements.getFile());
        } else {
            fileChooser.setTitle("Save file");
            File file = fileChooser.showSaveDialog(elements.getPrimaryStage());
            if(file != null) {
                elements.setFile(file);
                elements.getPcs().setPcs(elements.getComputers());
                FileReader.save(elements.getPcs(), elements.getFile());
            }
        }
    }

    private void handleSaveAsFileAction(ActionEvent event) {
        fileChooser.setTitle("Save file as");
        File file = fileChooser.showSaveDialog(elements.getPrimaryStage());

        if (file != null) {
            elements.getPcs().setPcs(elements.getComputers());
            FileReader.save(elements.getPcs(), file);
        }
    }

    private void handleNewWindowAction(ActionEvent event) {
        // Button was clicked, change color
        AppLaunchMain.startApp(AppLaunchMain.mainStage);
    }

    private void handleDeleteElementAction(ActionEvent event) {
        // Button was clicked, change color
        PC pcByPcName = getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString());
        elements.getComputers().remove(pcByPcName);
        elements.getListOfPcNames().setItems(FXCollections.observableArrayList(elements.getComputers().stream().map(PC::getPcName).collect(toList())));
        elements.getTable().setItems(FXCollections.observableList(new ArrayList<>()));
    }

    private static void clean(List<TextField> list) {
        list.forEach(TextInputControl::clear);
    }
}
