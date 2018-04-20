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
import java.util.Date;
import javafx.scene.control.Alert;

/**
 *
 * @author Amera
 */
public class Item {
    private int id;
    private String name;
    private String type;
    private String class_; //التصنيف
    private String code;
    private String supplyDate;
    private int quantity;
    private double price;
    private String supplyOrganization;
    private String expireDate;

    public Item() {
    }

    public Item(int id, String name, String type, String class_, String code, String supplyDate, int quantity, double price, String supplyOrganization, String expireDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.class_ = class_;
        this.code = code;
        this.supplyDate = supplyDate;
        this.quantity = quantity;
        this.price = price;
        this.supplyOrganization = supplyOrganization;
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(String supplyDate) {
        this.supplyDate = supplyDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplyOrganization() {
        return supplyOrganization;
    }

    public void setSupplyOrganization(String supplyOrganization) {
        this.supplyOrganization = supplyOrganization;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    
    public void addItem(Item item) {
        try{
            String sql = "INSERT INTO `item`(`name`, `type`, `class`, `code`, `supplyDate`, `quantity`, `price`, `supplyOrganization`, `expireDate`) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection = DB.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,item.getName());
            preparedStatement.setString(2,item.getType());
            preparedStatement.setString(3,item.getClass_());
            preparedStatement.setString(4,item.getCode());
            preparedStatement.setString(5,item.getSupplyDate());
            preparedStatement.setInt(6,item.getQuantity());
            preparedStatement.setDouble(7,item.getPrice());
            preparedStatement.setString(8,item.getSupplyOrganization());
            preparedStatement.setString(9,item.getExpireDate());
             
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information dialog");
            alert.setHeaderText("Good");
            alert.setContentText("Item Added Succesfully .");
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
    
    public static Item getItemById(int id){
        try{
            Connection connection = DB.Connect();
            String sql = "SELECT * FROM `item` WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Item item = new Item();
                item.setId(id);
                item.setName(rs.getString("name"));
                item.setType(rs.getString("type"));
                item.setClass_(rs.getString("class"));
                item.setCode(rs.getString("code"));
                item.setSupplyDate(rs.getString("supplyDate"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPrice(rs.getDouble("price"));
                item.setSupplyOrganization(rs.getString("supplyOrganization"));
                item.setExpireDate(rs.getString("expireDate"));
                return item ;
            }   
            rs.close();
            pstmt.close();
            connection.close();  
            return null;
        }catch(Exception ex){
            System.out.println(ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText(ex.toString());
            alert.show();
            return null;
        }
    }
    
    public void updateItem (Item item) {
        try{
            String sql = "UPDATE `item` SET `name`= ?,`type`= ?,`class`= ?"
                    + ",`code`= ?,`supplyDate`= ?,`quantity`= ?,`price`= ?"
                    + ",`supplyOrganization`= ?,`expireDate`= ? WHERE `id` =?";
            Connection connection = DB.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,item.getName());
            preparedStatement.setString(2,item.getType());
            preparedStatement.setString(3,item.getClass_());
            preparedStatement.setString(4,item.getCode());
            preparedStatement.setString(5,item.getSupplyDate());
            preparedStatement.setInt(6,item.getQuantity());
            preparedStatement.setDouble(7,item.getPrice());
            preparedStatement.setString(8,item.getSupplyOrganization());
            preparedStatement.setString(9,item.getExpireDate());
            preparedStatement.setInt(10,item.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("mmmm");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information dialog");
            alert.setHeaderText("Good");
            alert.setContentText("Information for Item number"+item.getId()+"Updated Succesfully ");
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
    
    public static void deleteItem(int id){
        try{
            
            Connection connection = DB.Connect();
            Statement stmt  = connection.createStatement();
            
            String sql = "INSERT INTO `itemarchive` SELECT * FROM `item` WHERE `id` ="+id;        
            stmt.executeUpdate(sql);
             sql = "DELETE FROM `item` WHERE `id` ="+id;
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information dialog");
            alert.setHeaderText("Item Deleted Succesfully");
            alert.setContentText(null);
            alert.show();
        }catch(Exception ex){
            
        }
    }
}