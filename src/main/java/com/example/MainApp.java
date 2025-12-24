package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


@SuppressWarnings("unused")


public class MainApp  extends Application{


   @Override 

   public void start ( Stage primaryStage ) throws Exception

   {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("registrationpage.fxml"));

    Scene scene = new Scene(loader.load());


     primaryStage.setScene(scene);


     primaryStage.setTitle("User Registration Form");

     primaryStage.show() ;

   }
    public static void main(String[] args) 
    {

        launch(args);
    }

}