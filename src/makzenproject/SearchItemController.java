/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class SearchItemController implements Initializable {

    @FXML
    private TableView itemTable;
    @FXML
    private TableColumn<Item, Integer> id;
    @FXML
    private TableColumn<Item, String> name;
    @FXML
    private TableColumn<Item, String> type;
    @FXML
    private TableColumn<Item, String> class_;
    @FXML
    private TableColumn<Item, String> code;
    @FXML
    private TableColumn<Item, String> supplyDate;
    @FXML
    private TableColumn<Item, Integer> quantity;
    @FXML
    private TableColumn<Item, Double> price;
    @FXML
    private TableColumn<Item, String> supplyOrg;
    @FXML
    private TableColumn<Item, String> ExpireDate;
    @FXML 
    private TextField searchText ;
    @FXML
    private DatePicker dateP;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `name` = ?";
           
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, searchText.getText());
           ResultSet rs = preparedStatement.executeQuery();
           
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void typeSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `type` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, searchText.getText());
           ResultSet rs = preparedStatement.executeQuery();
           
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void classSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `class` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, searchText.getText());
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void codeSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `code` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, searchText.getText());
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void quantitySearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `quantity` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1, Integer.parseInt(searchText.getText()));
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void priceSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `price` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setDouble(1, Double.parseDouble(searchText.getText()));
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void supplyOrgSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `supplyOrganization` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, searchText.getText());
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void supplyDateSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `supplyDate` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, dateP.getValue().toString());
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void expireDateSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `expireDate` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, dateP.getValue().toString());
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }

    @FXML
    private void idSearch(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `item` WHERE  `id` = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1, Integer.parseInt(searchText.getText()));
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           itemTable.setItems(items);
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           name.setCellValueFactory(new PropertyValueFactory<>("name"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
           class_.setCellValueFactory(new PropertyValueFactory<>("class_"));
           code.setCellValueFactory(new PropertyValueFactory<>("code"));
           supplyDate.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));
           quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
           price.setCellValueFactory(new PropertyValueFactory<>("price"));
           supplyOrg.setCellValueFactory(new PropertyValueFactory<>("supplyOrganization"));
           ExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
           if(items.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
           }
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There isn't any matching Item");
            alert.setTitle("Search completed !");
            alert.show();
            System.out.println(""+ex);
        }
    }
    
}
