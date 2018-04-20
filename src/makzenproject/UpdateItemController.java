/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class UpdateItemController implements Initializable {

    @FXML
    private DatePicker supplyDate;
    @FXML
    private DatePicker expireDate;
    @FXML
    private TextField supplyOrganization;
    @FXML
    private TextField price;
    @FXML
    private TextField quantity;
    @FXML
    private ComboBox class_;
    @FXML
    private TextField code;
    @FXML
    private TextField type;
    @FXML
    private TextField name;
    @FXML
    private ComboBox id;

    
    /**
     * Initializes the controller class.
     */
    ObservableList<String> classes = FXCollections.observableArrayList();
    ObservableList<Integer> ids = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Connection connection = DB.Connect();
            Statement st = connection.createStatement();
            String sql = "SELECT name FROM `class`";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                classes.add(rs.getString("name"));
            }
            class_.setItems(classes);
            
        }catch(Exception ex){
            
        }
        try{
            Connection connection = DB.Connect();
            Statement st = connection.createStatement();
            String sql = "SELECT id FROM `item`";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ids.add(rs.getInt("id"));
            }
            id.setItems(ids);
            
        }catch(Exception ex){
            
        }
    }    

    Item item = new Item();
    @FXML
    private void updateHandler(ActionEvent event) {
        try{
            item.setId((int)id.getValue());
            item.setName(name.getText());
            item.setType(type.getText());
            item.setClass_(class_.getValue().toString());
            item.setCode(code.getText());
            item.setExpireDate(expireDate.getValue().toString());
            item.setPrice(Double.parseDouble(price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setSupplyOrganization(supplyOrganization.getText());
            item.setSupplyDate(supplyDate.getValue().toString());
            item.updateItem(item);
        }catch(NullPointerException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText("Please Insert All information");
            alert.show();
        }
    }

    @FXML
    private void pickId(ActionEvent event) {
        Item item = Item.getItemById(Integer.parseInt(id.getValue().toString()));
        supplyDate.setValue(LocalDate.parse(item.getSupplyDate()));
        expireDate.setValue(LocalDate.parse(item.getExpireDate()));
        supplyOrganization.setText(item.getSupplyOrganization());
        price.setText(item.getPrice()+"");
        quantity.setText(item.getQuantity()+"");
        class_.setValue(item.getClass_());
        code.setText(item.getCode());
        type.setText(item.getType());
        name.setText(item.getName());
        
    }
    
}
