/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class AddEmployeesController implements Initializable {

    

    ObservableList<String> departments = FXCollections.observableArrayList("Internal Purchases","External Purchases","Counting Department","Mangement","Inventory Mangement","Humen Resources");
    
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private ToggleGroup g1;
    @FXML
    private TextField address;
    @FXML
    private DatePicker birthDate;
    @FXML
    private TextField salary;
    @FXML
    private TextField nationalty;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private ComboBox department;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        department.setItems(departments);
    }    
    Employee employee = new Employee();
    @FXML
    private void addEmployeeHandler(ActionEvent event) {
 
        try{
            employee.setFirstname(firstname.getText());
            employee.setLastname(lastname.getText());
            employee.setAddress(address.getText());
            employee.setBirthDate(birthDate.getValue().toString());
            employee.setEmail(email.getText());
            employee.setNationalty(nationalty.getText());
            employee.setSalary(Double.parseDouble(salary.getText()));
            employee.setPhoneNumber(phoneNumber.getText());
            employee.setDepartment(department.getValue().toString());
            if(male.isSelected()){
                employee.setGender("Male");
            }else{
                employee.setGender("Female");
            }
            employee.add(employee);
        }catch(NullPointerException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText("Please Insert All information");
            alert.show();
        }
         
    }
    
    @FXML
    public void resetHandler(ActionEvent event){
        firstname.setText("");
        lastname.setText("");
        address.setText("");
        birthDate.setValue(null);
        email.setText("");
        nationalty.setText("");
        salary.setText("");
        phoneNumber.setText("");
        department.setValue("");
    }

    
    
}
