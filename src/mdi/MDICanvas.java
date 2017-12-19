//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package mdi;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MDICanvas extends VBox {
    private final ScrollPane taskBar;
    private HBox tbWindows;
    private final AnchorPane paneMDIContainer;
    private MDICanvas mdiCanvas = this;
    private final int taskbarHeightWithoutScrool = 44;
    private final int taskbarHeightWithScrool = 54;
    public EventHandler<MDIEvent> mdiCloseHandler = (event) -> {
        MDIWindow win = (MDIWindow)event.getTarget();
        this.tbWindows.getChildren().remove(this.getItemFromToolBar(win.getId()));
        win = null;
    };
    public EventHandler<MDIEvent> mdiMinimizedHandler = (event) -> {
        MDIWindow win = (MDIWindow)event.getTarget();
        String id1 = win.getId();
        if (this.getItemFromToolBar(id1) == null) {
            try {
                MDIIcon icon = new MDIIcon(event.logo, this.mdiCanvas, win.getWindowsTitle());
                icon.setId(win.getId());
                icon.getBtnClose().disableProperty().bind(win.getBtnClose().disableProperty());
                this.tbWindows.getChildren().add(icon);
            } catch (Exception var5) {
                Logger.getLogger(MDICanvas.class.getName()).log(Level.SEVERE, (String)null, var5);
            }
        }

    };

    public MDICanvas() {
        this.setAlignment(Pos.TOP_LEFT);
        this.paneMDIContainer = new AnchorPane();
        this.paneMDIContainer.setId("MDIContainer");
        this.tbWindows = new HBox();
        this.tbWindows.setSpacing(3.0D);
        this.tbWindows.setMaxHeight(44.0D);
        this.tbWindows.setMinHeight(44.0D);
        this.tbWindows.setAlignment(Pos.CENTER_LEFT);
        setVgrow(this.paneMDIContainer, Priority.ALWAYS);
        this.taskBar = new ScrollPane(this.tbWindows);
        this.taskBar.setMaxHeight(44.0D);
        this.taskBar.setMinHeight(44.0D);
        this.taskBar.setVbarPolicy(ScrollBarPolicy.NEVER);
        this.taskBar.setVmax(0.0D);
        this.taskBar.setStyle(" -fx-border-color: #C4C4C4;  -fx-faint-focus-color: transparent;  -fx-focus-color: transparent; ");
        this.tbWindows.widthProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if (((Double)newValue).doubleValue() <= this.taskBar.getWidth()) {
                    this.taskBar.setMaxHeight(44.0D);
                    this.taskBar.setPrefHeight(44.0D);
                    this.taskBar.setMinHeight(44.0D);
                } else {
                    this.taskBar.setMaxHeight(54.0D);
                    this.taskBar.setPrefHeight(54.0D);
                    this.taskBar.setMinHeight(54.0D);
                }

            });
        });
        this.getChildren().addAll(new Node[]{this.paneMDIContainer, this.taskBar});
        this.addEventHandler(MDIEvent.EVENT_CLOSED, this.mdiCloseHandler);
        this.addEventHandler(MDIEvent.EVENT_MINIMIZED, this.mdiMinimizedHandler);
    }

    public AnchorPane getPaneMDIContainer() {
        return this.paneMDIContainer;
    }

    public HBox getTbWindows() {
        return this.tbWindows;
    }

    public void removeMDIWindow(String mdiWindowID) {
        Node mdi = this.getItemFromMDIContainer(mdiWindowID);
        Node iconBar = this.getItemFromToolBar(mdiWindowID);
        if (mdi != null) {
            this.paneMDIContainer.getChildren().remove(mdi);
        }

        if (iconBar != null) {
            this.tbWindows.getChildren().remove(iconBar);
        }

    }

    public void addMDIWindow(MDIWindow mdiWindow) {
        if (this.getItemFromMDIContainer(mdiWindow.getId()) == null) {
            mdiWindow.setVisible(false);
            this.paneMDIContainer.getChildren().add(mdiWindow);
            Platform.runLater(() -> {
                this.centerMdiWindow(mdiWindow);
                mdiWindow.setVisible(true);
            });
            mdiWindow.toFront();
        } else {
            if (this.getItemFromToolBar(mdiWindow.getId()) != null) {
                this.tbWindows.getChildren().remove(this.getItemFromToolBar(mdiWindow.getId()));
            }

            for(int i = 0; i < this.paneMDIContainer.getChildren().size(); ++i) {
                Node node = (Node)this.paneMDIContainer.getChildren().get(i);
                if (node.getId().equals(mdiWindow.getId())) {
                    ((MDIWindow)node).toFront();
                    ((MDIWindow)node).setVisible(true);
                }
            }
        }

    }

    public MDIIcon getItemFromToolBar(String id) {
        Iterator var2 = this.tbWindows.getChildren().iterator();

        while(var2.hasNext()) {
            Node node = (Node)var2.next();
            if (node instanceof MDIIcon) {
                MDIIcon icon = (MDIIcon)node;
                String key = icon.getId();
                if (key.equalsIgnoreCase(id)) {
                    return icon;
                }
            }
        }

        return null;
    }

    public MDIWindow getItemFromMDIContainer(String id) {
        Iterator var2 = this.paneMDIContainer.getChildren().iterator();

        while(var2.hasNext()) {
            Node node = (Node)var2.next();
            if (node instanceof MDIWindow) {
                MDIWindow win = (MDIWindow)node;
                if (win.getId().equals(id)) {
                    return win;
                }
            }
        }

        return null;
    }

    public void centerMdiWindow(MDIWindow mdiWindow) {
        try {
            double w = this.paneMDIContainer.getWidth();
            double h = this.paneMDIContainer.getHeight();
            double windowsHeight = ((AnchorPane)((AnchorPane)mdiWindow.getCenter()).getChildren().get(0)).getHeight() + ((AnchorPane)mdiWindow.getTop()).getHeight();
            double windowsWidth = ((AnchorPane)((AnchorPane)mdiWindow.getCenter()).getChildren().get(0)).getWidth();
            mdiWindow.setLayoutX((double)((int)(w / 2.0D) - (int)(windowsWidth / 2.0D)));
            mdiWindow.setLayoutY((double)((int)(h / 2.0D) - (int)(windowsHeight / 2.0D)));
            mdiWindow.setCache(false);
        } catch (Exception var10) {
            ;
        }

    }
}
