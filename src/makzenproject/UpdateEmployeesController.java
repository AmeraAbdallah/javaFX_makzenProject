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
import java.time.format.DateTimeFormatter;
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
public class UpdateEmployeesController implements Initializable {

    ObservableList<String> departments = FXCollections.observableArrayList("Internal Purchases","External Purchases","Counting Department","Mangement","Inventory Mangement","Humen Resources");
    ObservableList<Integer> ids = FXCollections.observableArrayList();
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup g1;
    @FXML
    private RadioButton female;
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
    private ComboBox id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      department.setItems(departments);
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
    
    Employee employee = new Employee();
    @FXML
    private void updateHandler(ActionEvent event) {
 
        
        try{
            employee.setId((int)id.getValue());
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
            employee.update(employee);
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
        
        Employee employee = Employee.getEmployeeById(Integer.parseInt(id.getValue().toString()));
        System.out.println(employee.getFirstname() + "name");
        firstname.setText(employee.getFirstname());
        lastname.setText(employee.getLastname());
        address.setText(employee.getAddress());
        birthDate.setPromptText(employee.getBirthDate());
        email.setText(employee.getEmail());
        nationalty.setText(employee.getNationalty());
        salary.setText(employee.getSalary()+"");
        phoneNumber.setText(employee.getPhoneNumber());
        department.setValue(employee.getDepartment());
            if(employee.getGender().equals("Male")){
                male.setSelected(true);
            }else if(employee.getGender().equals("Female")){
                female.setSelected(true);
            }
        birthDate.setValue(LocalDate.parse(employee.getBirthDate()));
    }
}
 