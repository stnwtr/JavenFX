package net.felium.javenfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new BorderPane(new Label("Center")), 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXEvent(type = FXEventType.MOUSE_EVENT_MOUSE_CLICKED, targets = {Button.class, TextField.class}) // try to add/remove textfield
    public void buttonClicked() {

    }
}
