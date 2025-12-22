package com.example;

public class controller {

    private struct object ;


public controller () throws Exception{

    DBconnection connection = new DBconnection() ;

    object = connection.getConnection();



    System.out.println("Tablename: "  + object.tablename);


}
 
public static void main ( String [] args ) throws Exception 
{

    new controller(); // this for testing part 
    

}

    
}
