package com.example.javafx1112.dao;

import com.example.javafx1112.User;
import com.example.javafx1112.dbhelper.ConnectDB;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM users";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCreatedAt(rs.getString("created_at"));
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }
        return users;
    }
    public static ArrayList<User> getUsersByUsername(String username) {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM users WHERE username LIKE '"+username+"%'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCreatedAt(rs.getString("created_at"));
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }
        return users;
    }

    public static int getCountUsers() {
        int count=0;
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM users";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               count++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void addUser(User user) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "INSERT INTO users (username,password) VALUES (?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(User user) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "UPDATE users SET username=?,password=? WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteUser(int id) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
