package net.felium.javenfx;

import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * https://github.com/stnwtr/
 *
 * @author stnwtr
 * @since 22.04.2019
 */
public enum FXEventType {
    /**
     * Fired on any mouse event.
     */
    MOUSE_EVENT_ANY(MouseEvent.ANY),

    /**
     * Fired on when mouse is clicked.
     */
    MOUSE_EVENT_MOUSE_CLICKED(MouseEvent.MOUSE_CLICKED),

    /**
     * Fired when mouse is moved.
     */
    MOUSE_EVENT_MOUSE_MOVED(MouseEvent.MOUSE_MOVED),

    /**
     * Fired on any key event
     */
    KEY_EVENT_ANY(KeyEvent.ANY),

    /**
     * Fired when a key is pressed.
     */
    KEY_EVENT_KEY_PRESSED(KeyEvent.KEY_PRESSED),

    /**
     * Fired when a key is released.
     */
    KEY_EVENT_KEY_RELEASED(KeyEvent.KEY_RELEASED);

    /**
     * The {@link EventType} of the event.
     */
    private EventType<?> type;

    /**
     * Simple constructor for event type.
     *
     * @param type The raw event type.
     */
    FXEventType(EventType<?> type) {
        this.type = type;
    }

    /**
     * Get the event type out of the enum.
     *
     * @return The raw event type.
     */
    public EventType<?> getType() {
        return type;
    }
}
