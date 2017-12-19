//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package mdi;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.image.ImageView;

public class MDIEvent extends Event {
    private static final long serialVersionUID = 2249682426993045124L;
    public static final EventType<MDIEvent> EVENT_CLOSED;
    public static final EventType<MDIEvent> EVENT_MINIMIZED;
    public ImageView logo;

    public MDIEvent(ImageView logoImage, EventType<? extends Event> eventType) {
        super(eventType);
        this.logo = logoImage;
    }

    public MDIEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    static {
        EVENT_CLOSED = new EventType(ANY, "EVENT_CLOSED");
        EVENT_MINIMIZED = new EventType(ANY, "EVENT_MINIMIZED");
    }
}
