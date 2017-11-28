package utils.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.PC;
import model.PCModels.*;
import model.PCs;

import java.util.List;
import java.util.Map;

/**
 * Created by sbogdanschi on 10/5/2017.
 */
public class Elements {

    public static final String Column1MapKey = "A";
    public static final String Column2MapKey = "B";
    final ComboBox listOfEnums = new ComboBox(FXCollections.observableArrayList(ProducerEnum.asStringList()));
    public static GridPane gridPane;

    private Button clear;
    private Button deleteObject;
    private CheckBox saveToFileCheckBox;
    private TableView<Map> table;
    private SpinnerValueFactory<Integer> powerSupplierValueFactorySpinner;
    private SpinnerValueFactory<Integer> priceValueFactorySpinner;
    private SpinnerValueFactory<Integer> hddValueFactorySpinner;
    private Spinner<Integer> priceSpinner;
    private Spinner<Integer> hddSpinner;
    private Spinner<Integer> powerSupplierSpinner;
    private ComboBox listOfPcNames;
    private Button createNewPc;
    private Button newCpu;
    private Button newMotherboard;
    private Button newRam;
    private Button newGraphicCard;
    public static Button submit;
    public static Button submitPc;
    private Button saveFile;
    private Button loadFile;
    private Button editFile;

    private TextField producerField;
    private TextField modelField;
    private TextField additionalInfoField;
    private TextField pcName;
    private TextField powerSupply;
    private TextField hddSize;
    private TextField price;

    private Label pcNameLabel;
    private Label label;
    private Label labelPc;
    private Label labelInfoPc;
    private Label priceLabel;
    private Label hddLabel;
    private Label powerSupplyLabel;

    private Cpu cpu;
    private GraphicCard graphicCard;
    private Motherboard motherboard;
    private Ram ram;
    private PC pc;
    private PCs pcs;

    private List<PC> computers;
    private ListView<String> viewElements;
    private ObservableList<String> items;
    private ObservableList<String> pEs; // producer enums
    private StackPane root;
    private Stage primaryStage;
    private Stage secondaryStage;

    public Label getPcNameLabel() {
        return pcNameLabel;
    }

    public void setPcNameLabel(Label pcNameLabel) {
        this.pcNameLabel = pcNameLabel;
    }

    public Button getClear() {
        return clear;
    }

    public void setClear(Button clear) {
        this.clear = clear;
    }

    public Label getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(Label priceLabel) {
        this.priceLabel = priceLabel;
    }

    public Label getHddLabel() {
        return hddLabel;
    }

    public void setHddLabel(Label hddLabel) {
        this.hddLabel = hddLabel;
    }

    public Label getPowerSupplyLabel() {
        return powerSupplyLabel;
    }

    public void setPowerSupplyLabel(Label powerSupplyLabel) {
        this.powerSupplyLabel = powerSupplyLabel;
    }

    public Button getDeleteObject() {
        return deleteObject;
    }

    public void setDeleteObject(Button deleteObject) {
        this.deleteObject = deleteObject;
    }

    public CheckBox getSaveToFileCheckBox() {
        return saveToFileCheckBox;
    }

    public void setSaveToFileCheckBox(CheckBox saveToFileCheckBox) {
        this.saveToFileCheckBox = saveToFileCheckBox;
    }

    public Button getEditFile() {
        return editFile;
    }

    public void setEditFile(Button editFile) {
        this.editFile = editFile;
    }

    public SpinnerValueFactory<Integer> getPowerSupplierValueFactorySpinner() {
        return powerSupplierValueFactorySpinner;
    }

    public void setPowerSupplierValueFactorySpinner(SpinnerValueFactory<Integer> powerSupplierValueFactorySpinner) {
        this.powerSupplierValueFactorySpinner = powerSupplierValueFactorySpinner;
    }

    public SpinnerValueFactory<Integer> getHddValueFactorySpinner() {
        return hddValueFactorySpinner;
    }

    public void setHddValueFactorySpinner(SpinnerValueFactory<Integer> hddValueFactorySpinner) {
        this.hddValueFactorySpinner = hddValueFactorySpinner;
    }

    public Spinner<Integer> getPriceSpinner() {
        return priceSpinner;
    }

    public void setPriceSpinner(Spinner<Integer> priceSpinner) {
        this.priceSpinner = priceSpinner;
    }

    public Spinner<Integer> getHddSpinner() {
        return hddSpinner;
    }

    public void setHddSpinner(Spinner<Integer> hddSpinner) {
        this.hddSpinner = hddSpinner;
    }

    public SpinnerValueFactory<Integer> getPriceValueFactorySpinner() {
        return priceValueFactorySpinner;
    }

    public void setPriceValueFactorySpinner(SpinnerValueFactory<Integer> priceValueFactorySpinner) {
        this.priceValueFactorySpinner = priceValueFactorySpinner;
    }

    public Spinner<Integer> getPowerSupplierSpinner() {
        return powerSupplierSpinner;
    }

    public void setPowerSupplierSpinner(Spinner<Integer> powerSupplierSpinner) {
        this.powerSupplierSpinner = powerSupplierSpinner;
    }

    public TableView<Map> getTable() {
        return table;
    }

    public void setTable(TableView<Map> table) {
        this.table = table;
    }

    public ComboBox getListOfEnums() {
        return listOfEnums;
    }

    public static GridPane getGridPane() {
        return gridPane;
    }

    public static void setGridPane(GridPane gridPane) {
        Elements.gridPane = gridPane;
    }

    public Button getCreateNewPc() {
        return createNewPc;
    }

    public void setCreateNewPc(Button createNewPc) {
        this.createNewPc = createNewPc;
    }

    public Button getNewCpu() {
        return newCpu;
    }

    public void setNewCpu(Button newCpu) {
        this.newCpu = newCpu;
    }

    public Button getNewMotherboard() {
        return newMotherboard;
    }

    public void setNewMotherboard(Button newMotherboard) {
        this.newMotherboard = newMotherboard;
    }

    public Button getNewRam() {
        return newRam;
    }

    public void setNewRam(Button newRam) {
        this.newRam = newRam;
    }

    public Button getNewGraphicCard() {
        return newGraphicCard;
    }

    public void setNewGraphicCard(Button newGraphicCard) {
        this.newGraphicCard = newGraphicCard;
    }

    public static Button getSubmit() {
        return submit;
    }

    public static void setSubmit(Button submit) {
        Elements.submit = submit;
    }

    public static Button getSubmitPc() {
        return submitPc;
    }

    public static void setSubmitPc(Button submitPc) {
        Elements.submitPc = submitPc;
    }

    public Button getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(Button saveFile) {
        this.saveFile = saveFile;
    }

    public Button getLoadFile() {
        return loadFile;
    }

    public void setLoadFile(Button loadFile) {
        this.loadFile = loadFile;
    }

    public TextField getProducerField() {
        return producerField;
    }

    public void setProducerField(TextField producerField) {
        this.producerField = producerField;
    }

    public TextField getModelField() {
        return modelField;
    }

    public void setModelField(TextField modelField) {
        this.modelField = modelField;
    }

    public TextField getAdditionalInfoField() {
        return additionalInfoField;
    }

    public void setAdditionalInfoField(TextField additionalInfoField) {
        this.additionalInfoField = additionalInfoField;
    }

    public TextField getPcName() {
        return pcName;
    }

    public void setPcName(TextField pcName) {
        this.pcName = pcName;
    }

    public TextField getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(TextField powerSupply) {
        this.powerSupply = powerSupply;
    }

    public TextField getHddSize() {
        return hddSize;
    }

    public void setHddSize(TextField hddSize) {
        this.hddSize = hddSize;
    }

    public TextField getPrice() {
        return price;
    }

    public void setPrice(TextField price) {
        this.price = price;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Label getLabelPc() {
        return labelPc;
    }

    public void setLabelPc(Label labelPc) {
        this.labelPc = labelPc;
    }

    public Label getLabelInfoPc() {
        return labelInfoPc;
    }

    public void setLabelInfoPc(Label labelInfoPc) {
        this.labelInfoPc = labelInfoPc;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }

    public PCs getPcs() {
        return pcs;
    }

    public void setPcs(PCs pcs) {
        this.pcs = pcs;
    }

    public List<PC> getComputers() {
        return computers;
    }

    public void setComputers(List<PC> computers) {
        this.computers = computers;
    }

    public ListView<String> getViewElements() {
        return viewElements;
    }

    public void setViewElements(ListView<String> viewElements) {
        this.viewElements = viewElements;
    }

    public ObservableList<String> getItems() {
        return items;
    }

    public void setItems(ObservableList<String> items) {
        this.items = items;
    }

    public ObservableList<String> getpEs() {
        return pEs;
    }

    public void setpEs(ObservableList<String> pEs) {
        this.pEs = pEs;
    }

    public StackPane getRoot() {
        return root;
    }

    public void setRoot(StackPane root) {
        this.root = root;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getSecondaryStage() {
        return secondaryStage;
    }

    public void setSecondaryStage(Stage secondaryStage) {
        this.secondaryStage = secondaryStage;
    }

    public ComboBox getListOfPcNames() {
        return listOfPcNames;
    }

    public void setListOfPcNames(ComboBox listOfPcNames) {
        this.listOfPcNames = listOfPcNames;
    }
}
