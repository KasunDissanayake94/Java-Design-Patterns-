/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.singleton;

/**
 *
 * @author Kasun Dissanayake
 */

class DatabaseConnection{
    //object of DatabaseConnection
    private static DatabaseConnection databaseConnection = new DatabaseConnection();
    
    //constructor private means cannot create instances
    private DatabaseConnection(){
        
    }
    //get the Object
    public static DatabaseConnection getInstance(){
        return databaseConnection;
    }
    public void getConnection(){
        System.out.println("Database Connected  Successfully...");
    }
    
}
public class Example2 {
    public static void main(String[] args) {
        DatabaseConnection object = DatabaseConnection.getInstance();
        object.getConnection();
        
        
    }
    
}
