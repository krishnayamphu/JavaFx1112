package com.example.javafx1112;

import com.example.javafx1112.dao.UserDAO;

import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) {
        ArrayList<User> users= UserDAO.getAllUsers();
        for(User user:users){
            System.out.println(user.getUsername());
        }
    }
}
