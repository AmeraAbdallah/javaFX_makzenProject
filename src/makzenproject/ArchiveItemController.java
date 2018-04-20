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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class ArchiveItemController implements Initializable {

    @FXML
    private TableView archiveTable;
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

    /**
     * Initializes the controller class.
     */
    ObservableList archiveItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM `itemarchive`";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           
           while(rs.next()){
               archiveItems.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9),rs.getString(10)));
           }
           archiveTable.setItems(archiveItems);
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
           
           preparedStatement.close();
           rs.close();
           connection.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.toString());
            alert.show();
            System.out.println(""+ex);
        }
    }  
    
}
