package scenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

/**
 * Created by sbogdanschi on 9/12/2017.
 */
public class PCScene extends Scene {

    public PCScene(Parent root) {
        super(root);
    }

    public PCScene(Parent root, double width, double height) {
        super(root, width, height);
    }

    public PCScene(Parent root, Paint fill) {
        super(root, fill);
    }

    public PCScene(Parent root, double width, double height, Paint fill) {
        super(root, width, height, fill);
    }

    public PCScene(Parent root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);
    }

    public PCScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
    }
}
