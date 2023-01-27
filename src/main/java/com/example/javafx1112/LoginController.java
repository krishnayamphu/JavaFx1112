package com.example.javafx1112;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    public void initialize(){
        System.out.println("logincontroller is working");
    }

    @FXML
    void auth(ActionEvent event) throws IOException {
        String username=txtusername.getText();
        String password=txtpassword.getText();
        if(username.equals("admin") && password.equals("a123")){
            FXMLLoader loader=new FXMLLoader(LoginApp.class.getResource("Welcome.fxml"));
            Parent root=loader.load();
            Scene scene=new Scene(root);
            Stage stage= (Stage) btnlogin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            System.out.println("welcome admin");
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid username or password");
            alert.show();
            System.out.println("invalid username or password");
        }
    }

}
