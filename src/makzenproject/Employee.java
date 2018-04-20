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
import java.util.Date;
import javafx.scene.control.Alert;

/**
 *
 * @author Amera
 */
public class Employee {

    
    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String address;
    private String birthDate;
    private String department;
    private Double Salary;
    private String nationalty;
    private String email;
    private String phoneNumber;

    public Employee() {
    }

    public Employee(int id, String firstname, String lastname,String gender , String address, String birthDate, String department, Double Salary, String nationalty, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.department = department;
        this.Salary = Salary;
        this.nationalty = nationalty;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }

    public String getNationalty() {
        return nationalty;
    }

    public void setNationalty(String nationalty) {
        this.nationalty = nationalty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void add(Employee employee) {
        try{
            String sql = "INSERT INTO `employee`(`firstName`, `lastName`, `gender`, `adress`, `birthDate`, `department`, `Salary`, `nationality`, `email`, `phoneNumber`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection = DB.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstname());
            preparedStatement.setString(2,employee.getLastname());
            preparedStatement.setString(3,employee.getGender());
            preparedStatement.setString(4,employee.getAddress());
            preparedStatement.setString(5,employee.getBirthDate());
            preparedStatement.setString(6,employee.getDepartment());
            preparedStatement.setDouble(7,employee.getSalary());
            preparedStatement.setString(8,employee.getNationalty());
            preparedStatement.setString(9,employee.getEmail());
            preparedStatement.setString(10,employee.getPhoneNumber());   
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information dialog");
            alert.setHeaderText("Good");
            alert.setContentText("Employee Added Succesfully .");
            alert.show();
            }
        catch(SQLException ex){
//            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText(ex.toString());
            alert.show();
        }
    }
    
    public static Employee getEmployeeById(int id){
        try{
            Connection connection = DB.Connect();
            String sql = "SELECT * FROM `employee` WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            //Employee employee = new Employee();
            while(rs.next()){
//                employee.setId(id);
//                employee.setFirstname(rs.getString(1));
//                employee.setLastname();
//                employee.setAddress();
//                employee.setBirthDate();
//                employee.setDepartment();
//                employee.setEmail();
//                employee.setPhoneNumber();
//                employee.setSalary(Double.NaN);
//                employee.setNationalty();
//                employee.setGender();

                Employee employee = new Employee(id,rs.getString(2),
                rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
                rs.getString(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getString(11));
                return employee;
            }
            rs.close();
            pstmt.close();
            connection.close();  
            return null;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }

    public void update(Employee employee) {
        try{
            String sql = "UPDATE `employee` SET `firstName` = ?, `lastName` =?, `gender` =?, `adress` =?, `birthDate` =?, `department` =?, `Salary` =?, `nationality` =?, `email` =?, `phoneNumber` =? WHERE `id` =?";
            Connection connection = DB.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstname());
            preparedStatement.setString(2,employee.getLastname());
            preparedStatement.setString(3,employee.getGender());
            preparedStatement.setString(4,employee.getAddress());
            preparedStatement.setString(5,employee.getBirthDate());
            preparedStatement.setString(6,employee.getDepartment());
            preparedStatement.setDouble(7,employee.getSalary());
            preparedStatement.setString(8,employee.getNationalty());
            preparedStatement.setString(9,employee.getEmail());
            preparedStatement.setString(10,employee.getPhoneNumber());
            preparedStatement.setInt(11,employee.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information dialog");
            alert.setHeaderText("Good");
            alert.setContentText("Information for Employee Updated Succesfullyfor employee number"+employee.getId());
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
    static void deleteEmployee(int id) {
        try{
            String sql = "DELETE FROM `employee` WHERE `id` ="+id;
            Connection connection = DB.Connect();
            PreparedStatement pstmt  = connection.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information dialog");
            alert.setHeaderText("Employee Deleted Succesfully");
            alert.setContentText(null);
            alert.show();
        }catch(Exception ex){
            
        }
    }  
}
