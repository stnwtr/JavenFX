package net.felium.javenfx;

import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public enum FXEventType {
    MOUSE_EVENT_ANY(MouseEvent.ANY),
    MOUSE_EVENT_MOUSE_CLICKED(MouseEvent.MOUSE_CLICKED),
    MOUSE_EVENT_MOUSE_MOVED(MouseEvent.MOUSE_MOVED),
    KEY_EVENT_KEY_PRESSED(KeyEvent.KEY_PRESSED);

    private EventType type;

    FXEventType(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }
}
