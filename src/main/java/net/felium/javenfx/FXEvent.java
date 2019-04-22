package net.felium.javenfx;

import javafx.scene.Node;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FXEvent {

    FXEventType type();

    FXEventPhase phase() default FXEventPhase.BUBBLING;

    Class<? extends Node>[] targets() default {};
}
