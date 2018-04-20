/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Amera
 */
public class User {
    int id;
    String name ;
    String password;
    String access;
    String nationalNumber;
    String email;
    String phoneNumber;

    
    
    public User() {
    }

    public User(int id, String name, String password, String access, String nationalNumber, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.access = access;
        this.nationalNumber = nationalNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(int id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    public static User getUser(int id){
        Connection conn = null;
        Statement stmt = null;
        try{
            System.out.println("Connecting to database...");
            conn = DB.Connect();
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `user` WHERE `id` ="+id;
            ResultSet rs = stmt.executeQuery(sql);
            User user = new User();
            while(rs.next()){
                user.id = rs.getInt("id");
                user.name = rs.getString("name");
                user.password = rs.getString("password");
                user.access = rs.getString("access");
                user.nationalNumber  = rs.getString("nationalNumber");
                user.email = rs.getString("email");
                user.phoneNumber = rs.getString("phoneNumber");
            }
            rs.close();
            stmt.close();
            conn.close();
            return user;
        }catch(SQLException  ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText(ex.toString());
            alert.show();
        }
        return null;
    }
    public static void add(User user){
        try{
        Connection connection = DB.Connect();
        String sql = "INSERT INTO `user`( `name`, `password`, `access`, `nationalNumber`, `email`, `phoneNumber`)"
                + " VALUES( ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getAccess());
        pstmt.setString(4, user.getNationalNumber());
        pstmt.setString(5, user.getEmail());
        pstmt.setString(6, user.getPhoneNumber());
        pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("add user ");
        alert.setHeaderText("Good");
        alert.setContentText("User have been added succefully");
        alert.showAndWait();
        }catch(Exception ex){
            
        }
    }
    public static void delete(int id){
        try{
            Connection connection = DB.Connect();
            String sql = "delete from user where id ="+id;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("delete user "+id);
            alert.setHeaderText("Good");
            alert.setContentText("User have been deleted succefully");
            }catch(Exception ex){

            }
    }
    
    public static void update(User user){
        try{
            String sql = "UPDATE `user` SET `name`=?,`password`=?,`access`=?,`nationalNumber`=?,`email`=?,"
                    + "`phoneNumber`=? WHERE `id` = ?";
            Connection connection = DB.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getAccess());
            preparedStatement.setString(4,user.getNationalNumber());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getPhoneNumber());
            preparedStatement.setDouble(7,user.getId());
            
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information dialog");
            alert.setHeaderText("Good");
            alert.setContentText("Information for Use Updated Succesfullyfor user number"+user.getId());
            alert.show();
            }
        catch(SQLException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText(ex.toString());
            alert.show();
        }
    }
}
