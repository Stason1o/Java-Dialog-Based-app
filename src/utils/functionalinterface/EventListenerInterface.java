package utils.functionalinterface;

import java.awt.event.ActionEvent;

@FunctionalInterface
public interface EventListenerInterface{
    void addListener(ActionEvent event);
}
