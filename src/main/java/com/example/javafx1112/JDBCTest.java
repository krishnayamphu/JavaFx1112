package com.example.javafx1112;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) {
        String username="root";
        String password="";
        String database="test";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,username,password);
            System.out.println("database server connected.");
            String sql="SELECT * FROM users";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            ArrayList<User> allUsers=new ArrayList<>();
            while (rs.next()){
                //System.out.println(rs.getInt("id")+" "+rs.getString("username")+" - "+rs.getString("password"));
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setCreatedAt(rs.getString("created_at"));
            allUsers.add(user);
            }

            for(User user:allUsers){
                System.out.println(user.getId()+" - "+user.getUsername()+" - "+user.getPassword());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
