/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Amera
 */
public class ViewUserController implements Initializable {

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> name;
    @FXML
    private TableColumn<User, String> password;
    @FXML
    private TableColumn<User, String> access;
    @FXML
    private TableColumn<User, String> nationalNum;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> phoneNum;

    /**
     * Initializes the controller class.
     */
    ObservableList<User> users = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            Connection conn = DB.Connect();
            String sql = "select * from user";
            Statement stmt = conn.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAccess(rs.getString("access"));
                user.setNationalNumber(rs.getString("nationalNumber"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            userTable.setItems(users);
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            password.setCellValueFactory(new PropertyValueFactory<>("password"));
            access.setCellValueFactory(new PropertyValueFactory<>("access"));
            nationalNum.setCellValueFactory(new PropertyValueFactory<>("nationalNumber"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            stmt.close();
            rs.close();
            conn.close();
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.toString());
            alert.show();
            System.out.println(""+ex);
        }
    }    
    
}
