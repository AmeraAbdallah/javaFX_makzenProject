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
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class DeletEmployeesController implements Initializable {

    ObservableList<Integer> ids = FXCollections.observableArrayList();
    
    @FXML
    private Label firstname;
    @FXML
    private Label lastname;
    @FXML
    private Label gender;
    @FXML
    private Label department;
    @FXML
    private Label address;
    @FXML
    private Label birthDate;
    @FXML
    private Label salary;
    @FXML
    private Label nationalty;
    @FXML
    private Label phoneNumber;
    @FXML
    private Label email;
    @FXML
    private ComboBox id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try{
          Connection connection = DB.Connect();
          String sql = "select id from employee";
          PreparedStatement pstmt = connection.prepareStatement(sql);
          ResultSet rs = pstmt.executeQuery();
          while(rs.next()){
              ids.add(rs.getInt("id"));
          }
          rs.close();
          pstmt.close();
          connection.close();
      }catch(Exception ex){
          
      }
      id.setItems(ids);
    }
    
    @FXML
    private void pickId(ActionEvent event) {
        
        Employee employee = Employee.getEmployeeById(Integer.parseInt(id.getValue().toString()));
        firstname.setText(employee.getFirstname());
        lastname.setText(employee.getLastname());
        address.setText(employee.getAddress());
        birthDate.setText(employee.getBirthDate());
        email.setText(employee.getEmail());
        nationalty.setText(employee.getNationalty());
        salary.setText(employee.getSalary()+"");
        phoneNumber.setText(employee.getPhoneNumber());
        department.setText(employee.getDepartment());
        gender.setText(employee.getGender());
        birthDate.setText(employee.getBirthDate());
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You Are going to delete  employee number "+id.getValue());
        alert.setContentText("Are you sure ?");
        Optional<ButtonType> optional = alert.showAndWait();
        if(optional.get() == ButtonType.OK){
            Employee.deleteEmployee(Integer.parseInt(id.getValue()+""));
        }else{
        }
    }
    
}
