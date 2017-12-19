package utils;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import model.PCModels.*;
import model.PCs;
import utils.model.Elements;
import model.PC;

import java.util.ArrayList;
import java.util.Map;

import static java.util.stream.Collectors.toList;

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

        elements.setNewFile(new Button());
        elements.setCreateFile(new Button());
        elements.setCreateNewPc(new Button("Create PC"));
        elements.setNewCpu(new Button("Add/Edit CPU"));
        elements.setNewMotherboard(new Button("Add/Edit MotherBoard"));
        elements.setNewRam(new Button("Add/Edit Ram"));
        elements.setNewGraphicCard(new Button("Add/Edit Graphic card"));
        elements.setSaveFile(new Button());
        elements.setLoadFile(new Button());
        elements.setEditFile(new Button());
        elements.setDeleteObject(new Button());
        elements.setNewWindow(new Button());
        elements.setSaveAsFile(new Button());
        elements.setClear(new Button("Clear"));

        Image img1 = new Image(getClass().getResourceAsStream("/resources/floppy-2.png"), 30, 30, true, true);
        Image img2 = new Image(getClass().getResourceAsStream("/resources/open(1).jpg"), 30, 30, true, true);
        Image img3 = new Image(getClass().getResourceAsStream("/resources/edit.png"), 30, 30, true, true);
        Image img4 = new Image(getClass().getResourceAsStream("/resources/delete pc.png"), 30, 30, true, true);
        Image img5 = new Image(getClass().getResourceAsStream("/resources/new_window.png"), 30, 30, true, true);
        Image img6 = new Image(getClass().getResourceAsStream("/resources/create pc.png"), 30, 30, true, true);
        Image img7 = new Image(getClass().getResourceAsStream("/resources/new file.png"), 30, 30, true, true);
        Image img8 = new Image(getClass().getResourceAsStream("/resources/save as.png"), 30, 30, true, true);

        elements.getSaveFile().setGraphic(new ImageView(img1));
        elements.getOpenFile().setGraphic(new ImageView(img2));
        elements.getEditFile().setGraphic(new ImageView(img3));
        elements.getDeleteObject().setGraphic(new ImageView(img4));
        elements.getNewFile().setGraphic(new ImageView(img5));
        elements.getCreateFile().setGraphic(new ImageView(img6));
        elements.getNewWindow().setGraphic(new ImageView(img7));
        elements.getSaveAsFile().setGraphic(new ImageView(img8));

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

        elements.getPc().setCpu(new Cpu());
        elements.getPc().setGraphicCard(new GraphicCard());
        elements.getPc().setRam(new Ram());
        elements.getPc().setMotherboard(new Motherboard());

        elements.setMenuBar(new MenuBar());
        elements.setMenuEdit(new Menu("Edit"));
        elements.setMenuFile(new Menu("File"));
        elements.setMenuView(new Menu("View"));

        elements.getMenuFile().getItems().addAll(new MenuItem("New"), new MenuItem("Open"), new MenuItem("Save"), new MenuItem("Save as"), new MenuItem("New window"));

        elements.getProducerField().setPromptText("Enter producer");
        elements.getModelField().setPromptText("Enter java.model");
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

        elements.getNewFile().setTooltip(new Tooltip("Create new file"));
                elements.getNewWindow().setTooltip(new Tooltip("Create new window"));
                elements.getOpenFile().setTooltip(new Tooltip("Open file"));
                elements.getSaveFile().setTooltip(new Tooltip("Save file"));
                elements.getSaveAsFile().setTooltip(new Tooltip("Save as file"));
                elements.getCreateFile().setTooltip(new Tooltip("Create new PC"));
                elements.getEditFile().setTooltip(new Tooltip("Edit PC"));
                elements.getDeleteObject().setTooltip(new Tooltip("Delete current PC"));
                elements.getListOfPcNames().setTooltip(new Tooltip("Show list of PC"));

        elements.setFileToolBar(new ToolBar(
                elements.getNewFile(),
                elements.getNewWindow(),
                elements.getOpenFile(),
                elements.getSaveFile(),
                elements.getSaveAsFile()
        ));

        elements.setEditToolBar(new ToolBar(
                elements.getCreateFile(),
                elements.getEditFile(),
                elements.getDeleteObject(),
                elements.getListOfPcNames()
        ));

//        elements.getTable().getColumns().addAll(new TableColumn("Field"), new TableColumn("Value"));
        elements.getMenuEdit().getItems().addAll(new MenuItem("Create PC"), new MenuItem("Edit PC"), new MenuItem("Delete current object"));
        elements.getMenuView().getItems().addAll(new MenuItem("Toolbar"));
        elements.getMenuBar().getMenus().setAll(elements.getMenuFile(), elements.getMenuEdit(), elements.getMenuView());
//        Elements.getGridPane().setHgap(10);
//        Elements.getGridPane().setVgap(10);
        Elements.getGridPane().setPadding(new Insets(0, 0, 0, 0));

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
        elements.getMenuBar().setMinSize(450, 30);
        elements.getTable().setMinSize(300, 600);
    }

    public static void setElementsToPane(Pane pane, Elements elements) {
        if (pane instanceof GridPane) {
            ((GridPane) pane).add(elements.getMenuBar(), 1, 1, 3, 1);
            ((GridPane) pane).add(elements.getFileToolBar(), 1, 2, 3, 1);
            ((GridPane) pane).add(elements.getOpenFile(), 1, 3);
//            ((GridPane) pane).add(elements.getListOfPcNames(), 1, 2);
            ((GridPane) pane).add(elements.getTable(), 1, 3, 3, 1);
            ((GridPane) pane).add(elements.getLabelInfoPc(), 2, 4);
            ((GridPane) pane).add(elements.getEditToolBar(), 1, 4, 3, 1);
//            ((GridPane) pane).add(elements.getSaveFile(), 1, 2);
//            ((GridPane) pane).add(elements.getEditFile(), 3, 1);
//            ((GridPane) pane).add(elements.getDeleteObject(), 3, 2);
//            ((GridPane) pane).add(elements.getClear(), 3, 3);
        }
    }

    public static TableView<Map> createTableView() {
        TableColumn<Map, String> firstDataColumn = new TableColumn<>("Field");
        TableColumn<Map, String> secondDataColumn = new TableColumn<>("Value");

        firstDataColumn.setCellValueFactory(new MapValueFactory(Elements.Column1MapKey));
        firstDataColumn.setMinWidth(250);
        secondDataColumn.setCellValueFactory(new MapValueFactory(Elements.Column2MapKey));
        secondDataColumn.setMinWidth(250);

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

    public static void addObjectToListOfPc(Elements elements, PC pc, ComboBox comboBox) {
        elements.getComputers().add(pc);
        comboBox.setItems(FXCollections.observableArrayList(elements.getComputers().stream().map(PC::getPcName).collect(toList())));
    }
}
