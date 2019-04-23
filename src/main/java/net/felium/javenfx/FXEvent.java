package net.felium.javenfx;

import javafx.scene.Node;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * https://github.com/stnwtr/
 *
 * @author stnwtr
 * @since 22.04.2019
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FXEvent {

    /**
     * The type of the Event.
     *
     * @return The type of the event.
     */
    FXEventType type();

    /**
     * The phase of the event which that tells when it is triggered.
     *
     * @return The phase of the event.
     */
    FXEventPhase phase() default FXEventPhase.BUBBLING;

    /**
     * An array of allowed nodes the event is triggered on.
     *
     * @return The class array of allowed nodes.
     */
    Class<? extends Node>[] targets() default {};
}
