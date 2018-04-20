/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Amera
 */
public class FXMLDocumentController implements Initializable {
    
    String pass ="";
    @FXML
    private Button button;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label labelid;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
        User user = User.getUser(Integer.parseInt(textField.getText()));
        String pass =  user.getPassword();
        System.out.println(pass);
        if(pass == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Some thing wrong");
            alert.setContentText("wrong id please try again");
            alert.show();
        }else{
            if(passwordField.getText().equals(pass)){
                //if(user.getAccess().equals("FullAccess")){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Fmain.fxml"));
                    loader.load();
                    FmainController fmain = loader.getController(); 
                    fmain.initData(user);
                    Parent page = loader.getRoot();
                    Scene scene = new Scene(page);
                    Stage  stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
               // }else{
                    //for low Access
                //} 
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Some thing wrong");
                alert.setContentText("wrong password please try again");
                alert.show();
            }  
        }   
    }catch(Exception ex){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Some thing messing");
        alert.setContentText(ex.toString());
        alert.show();
    }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleExitAction(ActionEvent event) {
        System.exit(0);
    }
    
}
