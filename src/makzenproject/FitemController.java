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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class FitemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    User user;
    
    @FXML
    private Button bClckd,userButton;
    @FXML
    private BorderPane borderPane;
    
    public void saveUseritem(User u){
         user = u ;
         if(u.getAccess().equals("Low Access")){
            userButton.setVisible(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void viewItems(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("ViewItem.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addItem(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("AddItems.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteItem(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("DeleteItem.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateItem(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("UpdateItem.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void archive(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("ArchiveItem.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchHndler(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MakzenProject.class.getResource("SearchItem.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) loader.load();
            borderPane.setCenter(anchorPane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    
    
}
