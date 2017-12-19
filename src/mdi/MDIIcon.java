//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package mdi;

import java.io.InputStream;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class MDIIcon extends Button {
    private Button btnClose;
    private Label lblName;
    private MDICanvas mdiCanvas;
    final String cssDefault = "-fx-border-color:blue;-fx-border-width: 1;-fx-spacing:5.0;-fx-alignment:center-left ";
    private EventHandler<MouseEvent> handleMaximize = (event) -> {
        MDIWindow win = this.mdiCanvas.getItemFromMDIContainer(this.getId());
        if (win != null) {
            win.setVisible(true);
            win.toFront();
            this.removeIcon();
        }

    };
    private EventHandler<MouseEvent> handleClose = (event) -> {
        this.removeMDIWindow();
        this.removeIcon();
    };

    public MDIIcon(ImageView logo, MDICanvas mdiCanvas, String name) throws Exception {
        HBox hBox = new HBox();
        hBox.setStyle("-fx-alignment:center-left");
        this.setStyle("-fx-background-color:   linear-gradient(#f2f2f2, #d6d6d6),  linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),  linear-gradient(#dddddd 0%, #f6f6f6 50%);  -fx-background-radius: 8,7,6;  -fx-background-insets: 0,1,2;  -fx-text-fill: black;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
        hBox.setSpacing(10.0D);
        hBox.setPadding(new Insets(0.0D, 10.0D, 0.0D, 10.0D));
        this.mdiCanvas = mdiCanvas;
        this.lblName = new Label(name);
        this.lblName.setStyle("-fx-font-weight: bold;");
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, this.handleMaximize);
        this.btnClose = new Button("", this.getImageFromResource("/assets/close.png"));
        DropShadow shadowCloseBtn = new DropShadow();
        shadowCloseBtn.setHeight(10.0D);
        shadowCloseBtn.setWidth(10.0D);
        this.btnClose.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            this.btnClose.setEffect(shadowCloseBtn);
        });
        this.btnClose.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            this.btnClose.setEffect((Effect)null);
            System.out.println("Height:" + this.getParent().getLayoutBounds().getHeight());
        });
        this.btnClose.addEventHandler(MouseEvent.MOUSE_CLICKED, this.handleClose);
        hBox.getChildren().addAll(new Node[]{logo, this.lblName, this.btnClose});
        this.setGraphic(hBox);
    }

    public Label getLblName() {
        return this.lblName;
    }

    private void removeMDIWindow() {
        MDIWindow win = this.mdiCanvas.getItemFromMDIContainer(this.getId());
        if (win != null) {
            this.mdiCanvas.getPaneMDIContainer().getChildren().remove(win);
        }

    }

    private void removeIcon() {
        MDIIcon icon = this.mdiCanvas.getItemFromToolBar(this.getId());
        if (icon != null) {
            this.mdiCanvas.getTbWindows().getChildren().remove(icon);
        }

    }

    private ImageView getImageFromResource(String imageName) throws Exception {
        InputStream in = this.getClass().getResourceAsStream(imageName);
        ImageView imvClose = new ImageView();
        if (in != null) {
            Image img = new Image(in);
            imvClose = new ImageView(img);
        }

        return imvClose;
    }

    public Button getBtnClose() {
        return this.btnClose;
    }

    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }
}
