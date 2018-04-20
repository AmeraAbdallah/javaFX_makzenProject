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
import java.util.Date;
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
public class ViewEmployeesController implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn<Employee,Integer> idClmn;
    @FXML
    private TableColumn<Employee, String> fNClmn;
    @FXML
    private TableColumn<Employee, String> lNClmn;
    @FXML
    private TableColumn<Employee, String> gClmn;
    @FXML
    private TableColumn<Employee, String> aClmn;
    @FXML
    private TableColumn<Employee, String> dOBClmn;
    @FXML
    private TableColumn<Employee, String> dClmn;
    @FXML
    private TableColumn<Employee, Double> sClmn;
    @FXML
    private TableColumn<Employee, String> nClmn;
    @FXML
    private TableColumn<Employee, String> eClmn;
    @FXML
    private TableColumn<Employee, String> pNClmn;
  
    ObservableList employees = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
           Connection connection = DB.Connect();
           String sql = "SELECT * FROM employee";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           
           while(rs.next()){
               employees.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getString(11)));
           }
           
           table.setItems(employees);
           idClmn.setCellValueFactory(new PropertyValueFactory<>("id"));
           fNClmn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
           lNClmn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
           gClmn.setCellValueFactory(new PropertyValueFactory<>("gender"));
           aClmn.setCellValueFactory(new PropertyValueFactory<>("address"));
           dOBClmn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
           dClmn.setCellValueFactory(new PropertyValueFactory<>("department"));
           sClmn.setCellValueFactory(new PropertyValueFactory<>("Salary"));
           nClmn.setCellValueFactory(new PropertyValueFactory<>("nationalty"));
           eClmn.setCellValueFactory(new PropertyValueFactory<>("email"));
           pNClmn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
           
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
