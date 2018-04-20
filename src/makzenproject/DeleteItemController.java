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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class DeleteItemController implements Initializable {

    ObservableList<String> classes = FXCollections.observableArrayList();
    ObservableList<Integer> ids = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox id;
    @FXML
    private Label name;
    @FXML
    private Label type;
    @FXML
    private Label code;
    @FXML
    private Label class_;
    @FXML
    private Label quantity;
    @FXML
    private Label price;
    @FXML
    private Label supplyOrganization;
    @FXML
    private Label expireDate;
    @FXML
    private Label supplyDate;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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

    @FXML
    private void pickId(ActionEvent event) {
        Item item = Item.getItemById(Integer.parseInt(id.getValue().toString()));
        supplyDate.setText(item.getSupplyDate());
        expireDate.setText(item.getExpireDate());
        supplyOrganization.setText(item.getSupplyOrganization());
        price.setText(item.getPrice()+"");
        quantity.setText(item.getQuantity()+"");
        class_.setText(item.getClass_());
        code.setText(item.getCode());
        type.setText(item.getType());
        name.setText(item.getName());
    }

    @FXML
    private void deletItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You Are going to delete  employee number "+id.getValue());
        alert.setContentText("Are you sure ?");
        Optional<ButtonType> optional = alert.showAndWait();
        if(optional.get() == ButtonType.OK){
           Item.deleteItem((int) id.getValue());
        }else{
        }
    }
    
}
