package com.example.javafx1112;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader(LoginApp.class.getResource("login.fxml"));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
