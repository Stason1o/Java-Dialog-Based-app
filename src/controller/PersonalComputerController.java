package controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.PC;
import model.PCModels.*;
import utils.ControllerUtils;
import utils.ElementUtils;
import utils.FileReader;
import utils.model.Elements;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static utils.model.Elements.*;

/**
 * Created by sbogdanschi on 9/13/2017.
 */
public class PersonalComputerController {

    private ElementUtils elementUtils;
    private Elements elements;

    public void initialize() {
        elementUtils = new ElementUtils();
        elements = new Elements();
        elementUtils.initPersonalComputerController(elements);
        initButtonActions(elements);
    }

    private void initButtonActions(Elements elements) {
        setOpenCreatePcDialog(elements.getCreateNewPc(), elements.getPc(), false);
        setActionToListOfPc();
        setActionToSaveButton();
        setActionToLoadButton();
        setClearAction();
        setDeleteAction();
    }

    private void setOpenCreatePcDialog(Button button, PC pc, boolean switcher) {
        initAction(elements.getNewCpu(), pc.getCpu(), switcher);
        initAction(elements.getNewMotherboard(), pc.getMotherboard(), switcher);
        initAction(elements.getNewGraphicCard(), pc.getGraphicCard(), switcher);
        initAction(elements.getNewRam(), pc.getRam(), switcher);
        button.setOnAction(event -> {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(elements.getPrimaryStage());
            VBox dialogVbox = new VBox(20);
            if (!switcher) {
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
                        submitPc,
                        elements.getSaveToFileCheckBox());
            } else {
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
                        submitPc,
                        elements.getSaveToFileCheckBox());
                elements.getPcName().setText(pc.getPcName());
                elements.getHddSpinner().getValueFactory().setValue(pc.getHddSize());
                elements.getPriceSpinner().getValueFactory().setValue(pc.getPrice().intValue());
                elements.getPowerSupplierSpinner().getValueFactory().setValue(pc.getPowerSupplier());
            }
            Scene dialogScene = new Scene(dialogVbox, 300, 650);
            dialog.setScene(dialogScene);
            dialog.show();
            submitSaveAction(submitPc, pc, dialog);
        });
    }

    private void setOpenEditPcDialog(Button button, PC pc) {
        setOpenCreatePcDialog(button, pc, true);
    }

    private void initAction(Button button, PCPart pcPart, boolean switcher) {
        button.setOnAction(event -> {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(elements.getPrimaryStage());
            VBox dialogVbox = new VBox(20);
            if (!switcher) {
                dialogVbox.getChildren().addAll(elements.getListOfEnums(), elements.getModelField(), elements.getAdditionalInfoField(), submit, elements.getLabel());
            } else {
                dialogVbox.getChildren().addAll(elements.getListOfEnums(), elements.getModelField(), elements.getAdditionalInfoField(), submit, elements.getLabel());
                elements.getListOfEnums().getSelectionModel().select(pcPart.getProducerEnum());
                elements.getModelField().setText(pcPart.getModel());
                elements.getAdditionalInfoField().setText(pcPart.getAddInfo());
                System.out.println(pcPart.getProducerEnum());
                System.out.println(pcPart.getModel());
                System.out.println(pcPart.getAddInfo());
            }
            Scene dialogScene = new Scene(dialogVbox, 300, 300);
            dialog.setScene(dialogScene);
            dialog.show();
            submitSaveAction(submit, pcPart, dialog);
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
                dialog.close();
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
                //                    clean(Arrays.asList(elements.getPcName(), elements.getPowerSupply(), elements.getPrice(), elements.getHddSize()));
                elements.getTable().setItems(getPcMap(getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString())));
                elements.getComputers().remove(elements.getComputers().stream().filter(element -> element.getPcName().equalsIgnoreCase(pc.getPcName())).findFirst().get());
                elements.getComputers().add(pc);
                elements.getPcs().setPcs(elements.getComputers());
//                System.out.println(elements.getComputers());
                if (elements.getSaveToFileCheckBox().isSelected()) {
                    FileReader.save(elements.getPcs());
                    elements.getTable().setItems(getPcMap(getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString())));
                }
            } else {
                System.out.println("Clear");
                //                    clean(Arrays.asList(elements.getPcName(), elements.getPowerSupply(), elements.getPrice(), elements.getHddSize()));
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
                FileReader.save(elements.getPcs());
            }
        });
    }

    private void setActionToLoadButton() {
        elements.getLoadFile().setOnAction((ActionEvent event) -> {
            elements.setComputers(FileReader.loadFile());
            if (elements.getComputers() != null) {
                elements.getListOfPcNames().setItems(FXCollections.observableArrayList(elements.getComputers().stream().map(PC::getPcName).collect(toList())));
            }
        });
    }

    private void setActionToListOfPc() {
        if (elements.getListOfPcNames() != null) {
            elements.getListOfPcNames().setOnAction(event -> {
//                System.out.println(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString());
                if (elements.getListOfPcNames().getSelectionModel().getSelectedItem() !=  null) {
                    PC localPc = getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString());
                    elements.getTable().setItems(getPcMap(localPc));
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
            map.put(Column1MapKey, listOfParams.get(i));
            map.put(Column2MapKey, listOfValues.get(i));
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

    private void setDeleteAction() {
        elements.getDeleteObject().setOnAction(event -> {
            PC pcByPcName = getPcByPcName(elements.getListOfPcNames().getSelectionModel().getSelectedItem().toString());
            elements.getComputers().remove(pcByPcName);
            elements.getListOfPcNames().setItems(FXCollections.observableArrayList(elements.getComputers().stream().map(PC::getPcName).collect(toList())));
            elements.getTable().setItems(FXCollections.observableList(new ArrayList<>()));
//            elements.getPcs().getPcs().remove(pcByPcName);
        });
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
                "CPU model",
                "CPU addInfo",
                "MotherBoard producer",
                "MotherBoard model",
                "MotherBoard addInfo",
                "GraphicCard producer",
                "GraphicCard model",
                "GraphicCard addInfo",
                "RAM producer",
                "RAM model",
                "RAM addInfo",
                "hddSize",
                "powerSupplier",
                "price"
        );
    }

    private static void clean(List<TextField> list) {
        list.forEach(TextInputControl::clear);
    }
}
