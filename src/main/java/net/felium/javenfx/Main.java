package net.felium.javenfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
//
//    @FXEvent(phase=Phase.HANDLING, type=Type.MOUSE_CLICKED, only={Button.class})
//    @FXEvent(phase=Phase.HANDLING, type=Type.MOUSE_MOVED, only={Pane.class})
//    public void onButtonClickOrOnPaneMoved(Event event) {
//        // button clicked
//    }
}
