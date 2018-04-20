/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField nationality;
    @FXML
    private ComboBox access;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> ac = FXCollections.observableArrayList("Full Access","Low Access");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        access.setItems(ac);
    }    

    @FXML
    private void addHandler(ActionEvent event) {
        User user = new User();
        user.setName(name.getText());
        user.setAccess(access.getValue().toString());
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        user.setNationalNumber(nationality.getText());
        user.setPhoneNumber(phoneNumber.getText());
        User.add(user);
    }

    @FXML
    private void resetHandler(ActionEvent event) {
        name.setText("");
        access.setValue(null);
        email.setText("");
        password.setText("");
        nationality.setText("");
        phoneNumber.setText("");
        
    }
    
}
