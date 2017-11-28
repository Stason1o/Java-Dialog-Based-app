package utils;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import model.PC;
import model.PCModels.*;
import model.PCs;
import utils.model.Elements;

import java.util.ArrayList;
import java.util.Map;

import static utils.model.Elements.Column1MapKey;
import static utils.model.Elements.Column2MapKey;

/**
 * Created by sbogdanschi on 10/5/2017.
 */
public class ElementUtils {

    public void initPersonalComputerController(Elements elements) {
        elements.setPriceValueFactorySpinner(new SpinnerValueFactory.IntegerSpinnerValueFactory(100, 100000));
        elements.setPowerSupplierValueFactorySpinner(new SpinnerValueFactory.IntegerSpinnerValueFactory(200, 2000));
        elements.setHddValueFactorySpinner(new SpinnerValueFactory.IntegerSpinnerValueFactory(120, 10000));
        elements.setPowerSupplierSpinner(new Spinner<>());
        elements.setHddSpinner(new Spinner<>());
        elements.setPriceSpinner(new Spinner<>());
        elements.setTable(createTableView());
        elements.setListOfPcNames(new ComboBox());
        elements.setViewElements(new ListView<>());
        elements.setItems(FXCollections.observableArrayList());
        elements.setItems(FXCollections.observableArrayList());
        elements.setpEs(FXCollections.observableArrayList(ProducerEnum.asStringList()));
        elements.getViewElements().setItems(elements.getItems());
        elements.setSaveToFileCheckBox(new CheckBox("Save to file"));

        Elements.setGridPane(new GridPane());
        elements.setSecondaryStage(new Stage());

        elements.setCreateNewPc(new Button("Create PC"));
        elements.setNewCpu(new Button("Add/Edit CPU"));
        elements.setNewMotherboard(new Button("Add/Edit MotherBoard"));
        elements.setNewRam(new Button("Add/Edit Ram"));
        elements.setNewGraphicCard(new Button("Add/Edit Graphic card"));
        elements.setSaveFile(new Button("Save"));
        elements.setLoadFile(new Button("Load file"));
        elements.setEditFile(new Button("Edit PC"));
        elements.setDeleteObject(new Button("Delete object"));
        elements.setClear(new Button("Clear"));

        Elements.setSubmit(new Button("submit"));
        Elements.setSubmitPc(new Button("submit"));

        elements.setLabel(new Label("Something to show"));
        elements.setLabelPc(new Label("Something to show"));
        elements.setLabelInfoPc(new Label("Something to show"));
        elements.setHddLabel(new Label("Hdd size"));
        elements.setPriceLabel(new Label("Price"));
        elements.setPowerSupplyLabel(new Label("Power Supply"));

        elements.setProducerField(new TextField());
        elements.setModelField(new TextField());
        elements.setAdditionalInfoField(new TextField());
        elements.setPcName(new TextField());
        elements.setPowerSupply(new TextField());
        elements.setHddSize(new TextField());
        elements.setPrice(new TextField());

        elements.setCpu(new Cpu());
        elements.setGraphicCard(new GraphicCard());
        elements.setMotherboard(new Motherboard());
        elements.setRam(new Ram());
        elements.setPc(new PC());
        elements.setPcs(new PCs());
        elements.setPcNameLabel(new Label("Pc name"));

        elements.getProducerField().setPromptText("Enter producer");
        elements.getModelField().setPromptText("Enter model");
        elements.getAdditionalInfoField().setPromptText("Enter additional info");
        elements.getPcName().setPromptText("Enter pc name");
        elements.getPowerSupply().setPromptText("Enter value of power supply");
        elements.getHddSize().setPromptText("Enter hdd size");
        elements.getPrice().setPromptText("Enter computer price");
        elements.getPowerSupplierSpinner().setValueFactory(elements.getPowerSupplierValueFactorySpinner());
        elements.getHddSpinner().setValueFactory(elements.getHddValueFactorySpinner());
        elements.getPriceSpinner().setValueFactory(elements.getPriceValueFactorySpinner());
        elements.setComputers(new ArrayList<>());
        elements.getHddSpinner().setEditable(true);
        elements.getPriceSpinner().setEditable(true);
        elements.getPowerSupplierSpinner().setEditable(true);
//        elements.getTable().getColumns().addAll(new TableColumn("Field"), new TableColumn("Value"));

        Elements.getGridPane().setHgap(10);
        Elements.getGridPane().setVgap(10);
        Elements.getGridPane().setPadding(new Insets(0, 10, 0, 10));

        setElementsToPane(Elements.getGridPane(), elements);
        setSize(elements);

    }
    public static void setSize(Elements elements) {
        elements.getNewCpu().setMinSize(100, 30);
        elements.getNewMotherboard().setMinSize(100, 30);
        elements.getNewRam().setMinSize(100, 30);
        elements.getNewGraphicCard().setMinSize(100, 30);

        elements.getNewCpu().setMaxSize(300, 300);
        elements.getNewMotherboard().setMaxSize(300, 300);
        elements.getNewRam().setMaxSize(300, 300);
        elements.getNewGraphicCard().setMaxSize(300, 300);
    }

    public static void setElementsToPane(Pane pane, Elements elements) {
        if(pane instanceof GridPane) {
            ((GridPane) pane).add(elements.getCreateNewPc(), 1, 1);
            ((GridPane) pane).add(elements.getTable(), 2, 2);
            ((GridPane) pane).add(elements.getSaveFile(), 1, 2);
            ((GridPane) pane).add(elements.getLoadFile(), 1, 3);
            ((GridPane) pane).add(elements.getLabelInfoPc(), 2, 3);
            ((GridPane) pane).add(elements.getListOfPcNames(), 2, 1);
            ((GridPane) pane).add(elements.getEditFile(), 3, 1);
            ((GridPane) pane).add(elements.getDeleteObject(), 3, 2);
//            ((GridPane) pane).add(elements.getClear(), 3, 3);
        }
    }

    private static TableView<Map> createTableView() {
        TableColumn<Map, String> firstDataColumn = new TableColumn<>("Field");
        TableColumn<Map, String> secondDataColumn = new TableColumn<>("Value");

        firstDataColumn.setCellValueFactory(new MapValueFactory(Column1MapKey));
        firstDataColumn.setMinWidth(130);
        secondDataColumn.setCellValueFactory(new MapValueFactory(Column2MapKey));
        secondDataColumn.setMinWidth(130);

        TableView<Map> tableView = new TableView<>();

//        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getColumns().setAll(firstDataColumn, secondDataColumn);
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

        return tableView;
    }
 }
