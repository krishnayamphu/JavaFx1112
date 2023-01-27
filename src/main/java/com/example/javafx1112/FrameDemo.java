package com.example.javafx1112;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FrameDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane=new AnchorPane();
        Label lbltxt=new Label("JavaFx Application");
        pane.getChildren().add(lbltxt);
        Scene scene=new Scene(pane,400,300);
        stage.setScene(scene);
        stage.setTitle("JavaFx Frame Example");
        stage.show();
        System.out.println("javafx application");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
