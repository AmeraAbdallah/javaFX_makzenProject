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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class UpdateUserController implements Initializable {

    @FXML
    private ComboBox id;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private ComboBox access;
    @FXML
    private TextField nationalityNum;
    @FXML
    private TextField phoneNum;
    @FXML
    private TextField email;
    
    
    ObservableList<Integer> ids = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
          Connection connection = DB.Connect();
          String sql = "select id from user";
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
        
        User user = User.getUser(Integer.parseInt(id.getValue()+""));
        name.setText(user.getName());
        password.setText(user.getPassword());
        access.setValue(user.getAccess());
        nationalityNum.setText(user.getNationalNumber());
        phoneNum.setText(user.getPhoneNumber());
        email.setText(user.getEmail());
    }   

    @FXML
    private void handleUpdate(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You Are going to update info for  user number "+id.getValue());
        alert.setContentText("Are you sure ?");
        Optional<ButtonType> optional = alert.showAndWait();
        if(optional.get() == ButtonType.OK){
            User user = new User();
            user.setName(name.getText());
            user.setAccess(access.getValue().toString());
            user.setEmail(email.getText());
            user.setId(Integer.parseInt(id.getValue().toString()));
            user.setPassword(password.getText());
            user.setNationalNumber(nationalityNum.getText());
            user.setPhoneNumber(phoneNum.getText());
            User.update(user);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Good");
            alert.setContentText("Information updated succefully");
        }else{
        }
    }
    
}
