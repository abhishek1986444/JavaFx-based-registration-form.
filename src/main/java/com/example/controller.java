package com.example;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.*;

import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField ;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;


import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;


@SuppressWarnings(  "unused" )




public class controller {

// ----------------- fxml fields  - ------



    @FXML private TextField useridField;

    @FXML private TextField usernameField ;

    @FXML private TextField mailField ;

    @FXML private PasswordField passwordField ;

    @FXML private CheckBox termsCheckBox ; 

    @FXML private Label statusLabel ; 



    private struct object ;


public  controller () throws Exception{

    DBconnection connection = new DBconnection() ;

    object = connection.getConnection();



}
 


public  void  register() throws SQLException 

 
{


 String user_id = useridField.getText().trim();

String mail_id = mailField.getText().trim() ; 

String password = passwordField.getText().trim();

String username = usernameField.getText().trim() ;



 termsCheckBox.getStyleClass().remove("error-checkbox"); // reset

    

    if (useridField.getText().isEmpty()
            || usernameField.getText().isEmpty()
            || mailField.getText().isEmpty()
            || passwordField.getText().isEmpty()) {

        showError("All fields are required ❌");
        return;
    }


if ( !termsCheckBox.isSelected())
{
System.out.println("User doesn't selected checkbox");

    termsCheckBox.getStyleClass().add("error-checkbox"); // highlight

    showError("You must agree to the Terms and Conditions to register.");

    passwordField.clear();

password = "" ;
return ;

}



System.out.println( " User name " + username);  //  this statements are four testing purposes 
System.out.println( "User Id  " + user_id); // 
System.out.println(  "mail id " + mail_id);  //


showSuccess("Registration successful ✔");



String userinput = " insert into userrecord (userid , mailid , password, username ) values ( ?, ? , ?  , ? )  ;   " ; 

PreparedStatement ps = object.connection.prepareStatement(userinput);




ps.setString( 1,user_id );
ps.setString( 2,mail_id);

ps.setString( 3, password);

ps.setString( 4, username );


System.out.println(ps.executeUpdate());

// ps.close();

//object.connection.close();


     useridField.clear();
     mailField.clear();
     passwordField.clear();
     usernameField.clear();





}





private void showSuccess(String message) {
    statusLabel.setText(message);
    statusLabel.setVisible(true);
    statusLabel.getStyleClass().removeAll("status-error");
    statusLabel.getStyleClass().addAll("status-label", "status-success");
}

private void showError(String message) {
    statusLabel.setText(message);
    statusLabel.setVisible(true);
    statusLabel.getStyleClass().removeAll("status-success");
    statusLabel.getStyleClass().addAll("status-label", "status-error");
}


@FXML private void openTermsScene( ActionEvent event)  throws IOException 

{


    if ( !termsCheckBox.isSelected())

        return ;


  
  Parent  rootofterms = FXMLLoader.load(getClass().getResource("/com/example/termspage.fxml"));


   Stage stage = new Stage();


   stage.setTitle("Terms and Conditions");


   stage.setScene(new Scene ( rootofterms )) ;


   stage.initOwner(
    ((Node) event.getSource()).getScene().getWindow()
); // need review 



   stage.show();



   

}
    
}



