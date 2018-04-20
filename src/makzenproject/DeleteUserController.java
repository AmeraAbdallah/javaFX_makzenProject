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

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class DeleteUserController implements Initializable {

    @FXML
    private ComboBox id;
    @FXML
    private Label name;
    @FXML
    private Label password;
    @FXML
    private Label access;
    @FXML
    private Label nationalityNum;
    @FXML
    private Label phoneNum;
    @FXML
    private Label email;

    /**
     * Initializes the controller class.
     */
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
        access.setText(user.getAccess());
        nationalityNum.setText(user.getNationalNumber());
        phoneNum.setText(user.getPhoneNumber());
        email.setText(user.getEmail());
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You Are going to delete  user number "+id.getValue());
        alert.setContentText("Are you sure ?");
        Optional<ButtonType> optional = alert.showAndWait();
        if(optional.get() == ButtonType.OK){
            User.delete(Integer.parseInt(id.getValue()+""));
        }else{
        }
    }
    
}
