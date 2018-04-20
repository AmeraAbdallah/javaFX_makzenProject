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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class FmainController implements Initializable {

    User user;
    @FXML 
    private Label lableName ;
    @FXML
    private Label lableId;
    @FXML
    private Label labelNM;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelPN;
    @FXML
    private Label labelAccess;
    @FXML
    private Button bClckd;
    @FXML
    private Button userButton;
    /**
     * Initializes the controller class.
     */

    public void initData(User u){
        user = u ;
        lableId.setText(user.getId()+"");
        lableName.setText(user.getPassword());
        labelNM.setText(user.getNationalNumber());
        labelEmail.setText(user.getEmail());
        labelPN.setText(user.getPhoneNumber());
         labelAccess.setText(user.getAccess());
        System.out.println(user.getName());
        if(u.getAccess().equals("Low Access")){
            userButton.setVisible(false);
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bClckd.setDisable(true);
        
    }   

    @FXML
    private void handleEmp(ActionEvent event) {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Femp3.fxml"));
        try{
            loader.load();
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        FempController femp = loader.getController(); 
        femp.saveUser(user);
        Parent page = loader.getRoot();
        Scene scene = new Scene(page);
        Stage  stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleItems(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Fitem.fxml"));
        try{
            loader.load();
        }catch(Exception ex){
            
        }
        
        FitemController fitem = loader.getController(); 
        fitem.saveUseritem(user);
        Parent page = loader.getRoot();
        Scene scene = new Scene(page);
        Stage  stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    

    @FXML
    private void handleUsers(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Fuser.fxml"));
        try{
            loader.load();
        }catch(Exception ex){
            
        }
        FuserController fuser = loader.getController(); 
        fuser.saveUseruser(user);
        Parent page = loader.getRoot();
        Scene scene = new Scene(page);
        Stage  stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleProfile(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Fmain.fxml"));
        try{
            loader.load();
        }catch(Exception ex){
            
        }
        
        FmainController fmain = loader.getController(); 
        fmain.initData(user);
        Parent page = loader.getRoot();
        Scene scene = new Scene(page);
        Stage  stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void hadleLogout(ActionEvent event) {
        try{
            Parent page = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(page);
            Stage  stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
   
     
    
}
