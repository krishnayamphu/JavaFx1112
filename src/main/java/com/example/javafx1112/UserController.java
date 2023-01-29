package com.example.javafx1112;

import com.example.javafx1112.dao.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class UserController {

    @FXML
    private TableView<User> tblUser;

    @FXML
    private TableColumn<User, Integer> colId;

    @FXML
    private TableColumn<User, String> colUsername;

    @FXML
    private TableColumn<User, String> colPassword;

    @FXML
    private TableColumn<User, String> colCreatedAt;

    @FXML
    public void initialize(){
        loadUsers();
    }

    public void loadUsers(){
        ArrayList<User> allUsers= UserDAO.getAllUsers();
        ObservableList userList= FXCollections.observableList(allUsers);
        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        colCreatedAt.setCellValueFactory(new PropertyValueFactory<User,String>("createdAt"));
        tblUser.setItems(userList);
    }

}
