package com.example ;



import java.sql.*;


import java.io.IOException ;
import java.io.InputStream;
import java.io.FileInputStream;

import java.util.Properties;







@SuppressWarnings("unused")



public class DBconnection {

    public struct getConnection() throws Exception
    {
        struct object = new struct();



Properties props = new Properties();


InputStream fis = getClass().getClassLoader()
        .getResourceAsStream("com/example/db.properties");


        props.load(fis);
        

        String url = props.getProperty("db.url");

        String  driver = props.getProperty("db.driver");
        
        String password = props.getProperty("db.password");

        String tablename = props.getProperty("db.tablename");

        String username = props.getProperty("db.username");


        Class.forName(driver);



        object.conn = DriverManager.getConnection(url,username,password);

        object.tablename = tablename ;







fis.close();


System.out.println("Connection succesfull!");


        return object ;



    }


    
}


class struct {

public  Connection conn ;

   public  String tablename ;


    struct ()
    { 
        conn = null ;

        tablename = "";

    }

    struct ( Connection conn , String tablename )
    {
          this.conn = conn ;
          this.tablename = tablename ;


          
    }

}