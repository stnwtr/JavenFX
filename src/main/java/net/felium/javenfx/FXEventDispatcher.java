package net.felium.javenfx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * https://github.com/stnwtr/
 *
 * @author stnwtr
 * @since 22.04.2019
 */
public class FXEventDispatcher {

    /**
     * Checks if a method's modifiers are allowed.
     *
     * @param method The method to check.
     * @return If the method is allowed.
     */
    private static boolean isAllowed(@Nonnull Method method) {
        int modifiers = method.getModifiers();
        boolean allowed = !(Modifier.isAbstract(modifiers) || Modifier.isNative(modifiers) || Modifier.isStatic(modifiers)) && Modifier.isPublic(modifiers);
        if (!allowed)
            System.err.println("Illegal modifier at method '" + method.toString() + '\'');
        return allowed;
    }

    /**
     * Registers an the methods marked with {@link FXEvent} as an {@link FXEventListener} for a specific node.
     *
     * @param node The node which calls the event.
     * @param listener The Listener which contains the event methods.
     */
    public static void registerEvent(@Nonnull Node node, @Nonnull FXEventListener listener) {
        Arrays.stream(listener.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(FXEvent.class))
                .filter(FXEventDispatcher::isAllowed)
                .forEach(method -> {
                    FXEvent fxEvent = method.getDeclaredAnnotation(FXEvent.class);
                    FXEventType type = fxEvent.type();
                    FXEventPhase phase = fxEvent.phase();

                    if (Arrays.stream(fxEvent.targets()).noneMatch(aClass -> aClass.isInstance(node)))
                        return;

                    EventHandler<Event> handler = event -> {
                        try {
                            if (method.getParameterCount() == 0) {
                                method.invoke(listener);
                            } else if (method.getParameterCount() == 1) {
                                method.invoke(listener, event);
                            }
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    };

                    if (phase.equals(FXEventPhase.FILTER) || phase.equals(FXEventPhase.CAPTURING))
                        node.addEventFilter(type.getType(), handler);
                    else if (phase.equals(FXEventPhase.HANDLER) || phase.equals(FXEventPhase.BUBBLING))
                        node.addEventHandler(type.getType(), handler);
                });
    }
}
