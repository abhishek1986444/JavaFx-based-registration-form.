package com.example;

import java.sql.SQLException;

import java.sql.*;

import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TextField;


import javafx.scene.control.PasswordField ;

import javafx.scene.control.Alert;


import javafx.scene.control.Alert.AlertType;




@SuppressWarnings(  "unused" )




public class controller {

// ----------------- fxml fields  - ------



    @FXML  private TextField useridField;

    @FXML private TextField usernameField ;


    @FXML private TextField mailField ;

    @FXML private PasswordField passwordField ;



    private struct object ;


public  controller () throws Exception{

    DBconnection connection = new DBconnection() ;

    object = connection.getConnection();



}
 


public  void  register() throws SQLException  // add register function in the controller.java file 

 
{

 String user_id = useridField.getText().trim();

System.out.println( "User Id  " + user_id);

String mail_id = mailField.getText().trim() ; 

System.out.println(  "mail id " + mail_id);



String password = passwordField.getText().trim();

System.out.println(  "Password " + password);




String username = usernameField.getText().trim() ;


System.out.println( " User name " + username);






String userinput = " insert into userrecord (userid , mailid , password, username ) values ( ?, ? , ?  , ? )  ;   " ; 

PreparedStatement ps = object.connection.prepareStatement(userinput);




ps.setString( 1,user_id );
ps.setString( 2,mail_id);

ps.setString( 3, password);

ps.setString( 4, username );


System.out.println(ps.executeUpdate());

ps.close();

object.connection.close();



}



    
}



