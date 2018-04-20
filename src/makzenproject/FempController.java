/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.io.IOException;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class FempController implements Initializable {
    User user;
    
//    @FXML
//    private AnchorPane anchorPane;
    
    @FXML
    BorderPane borderPane;

    @FXML
    private Button bClckd , userButton;
    
    
    
    public void saveUser(User u){
         user = u ;
         if(u.getAccess().equals("Low Access")){
            userButton.setVisible(false);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bClckd.setDisable(true);
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
    private void handleEmp(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Femp3.fxml"));
        try{
            loader.load();
        }catch(Exception ex){
            
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
    private void viewEmployees(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("ViewEmployees.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
//            anchorPane.getChildren().clear();
//            anchorPane.getChildren().add(anchorPane1);
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addEmployees(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("AddEmployees.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteEmployees(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("DeletEmployees.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateEmployees(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("UpdateEmployees.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    
}
