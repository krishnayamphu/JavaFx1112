package com.example.javafx1112;

import com.example.javafx1112.dao.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    private TextField txtId;

    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtSearch;

    @FXML
    private Label lblTotal;

    @FXML
    public void initialize() {
        loadUsers();
    }

    public void loadUsers() {
        ArrayList<User> allUsers = UserDAO.getAllUsers();
        ObservableList userList = FXCollections.observableList(allUsers);
        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        colCreatedAt.setCellValueFactory(new PropertyValueFactory<User, String>("createdAt"));
        tblUser.setItems(userList);
        getTotalUsers();
    }

    @FXML
    void addUser(ActionEvent event) {
        String username = txtusername.getText();
        String password = txtpassword.getText();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDAO.addUser(user);
        loadUsers();
        clearFields();
    }

    @FXML
    void getUser(MouseEvent event) {
        User user = tblUser.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(user.getId()));
        txtusername.setText(user.getUsername());
        txtpassword.setText(user.getPassword());
    }

    @FXML
    void editUser(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String username = txtusername.getText();
        String password = txtpassword.getText();
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        UserDAO.updateUser(user);
        loadUsers();
        clearFields();
    }

    @FXML
    void removeUser(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        UserDAO.deleteUser(id);
        loadUsers();
        clearFields();
    }

    @FXML
    void searchUser(KeyEvent event) {
        String username = txtSearch.getText();
        ArrayList<User> allUsers = UserDAO.getUsersByUsername(username);
        ObservableList userList = FXCollections.observableList(allUsers);
        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        colCreatedAt.setCellValueFactory(new PropertyValueFactory<User, String>("createdAt"));
        tblUser.setItems(userList);
    }


    void clearFields() {
        txtId.setText("");
        txtusername.setText("");
        txtpassword.setText("");
    }
    void getTotalUsers(){
        lblTotal.setText(String.valueOf(UserDAO.getCountUsers()));
    }

}
