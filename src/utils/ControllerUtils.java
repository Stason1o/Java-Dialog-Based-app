package utils;

import javafx.scene.control.TextField;
import model.PCModels.PCPart;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

/**
 * Created by sbogdanschi on 9/12/2017.
 */
public class ControllerUtils {

    public static boolean isNotEmpty(PCPart...pcParts) {
        return Arrays.stream(pcParts).filter(PCPart::isEmpty).collect(toList()).size() == 0;
    }

    public static boolean isNotEmpty(TextField...nodes) {
        return Arrays.stream(nodes).filter(node -> node.getText().isEmpty()).collect(toList()).size() == 0;
    }
}
