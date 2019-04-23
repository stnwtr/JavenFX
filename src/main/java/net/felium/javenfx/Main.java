package net.felium.javenfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements FXEventListener {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Button button = new Button("Click me!");
        TextField textField = new TextField("Edit me!");

        root.getChildren().addAll(button, textField);

        FXEventDispatcher.registerEvent(button, this);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @FXEvent(type = FXEventType.MOUSE_EVENT_MOUSE_CLICKED, targets = Button.class)
    public void onButtonClick(MouseEvent event) {
        System.out.println("click.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
