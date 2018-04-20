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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class AddItemsController implements Initializable {

    ObservableList<String> classes = FXCollections.observableArrayList();
    
    @FXML
    private TextField name;
    @FXML
    private TextField type;
    @FXML
    private TextField code;
    @FXML
    private DatePicker supplyDate;
    @FXML
    private ComboBox class_;
    @FXML
    private TextField quantity;
    @FXML
    private TextField price;
    @FXML
    private TextField supplyOrganization;
    @FXML
    private DatePicker expireDate;

    
    /**
     * Initializes the controller class.
     */
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
    }    

    Item item = new Item();
    @FXML
    private void addHandler(ActionEvent event) {
        try{
            item.setName(name.getText());
            item.setType(type.getText());
            item.setClass_(class_.getValue().toString());
            item.setCode(code.getText());
            item.setExpireDate(expireDate.getValue().toString());
            item.setPrice(Double.parseDouble(price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setSupplyOrganization(supplyOrganization.getText());
            item.setSupplyDate(supplyDate.getValue().toString());
            item.addItem(item);
        }catch(NullPointerException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText("Please Insert All information");
            alert.show();
        }
    }

    @FXML
    private void resetHandler(ActionEvent event) {
        name.setText("");
        type.setText("");
        class_.setValue("");
        code.setText("");
        expireDate.setValue(null);
        price.setText("");
        quantity.setText("");
        supplyOrganization.setText("");
        supplyDate.setValue(null);
    }
    
}
