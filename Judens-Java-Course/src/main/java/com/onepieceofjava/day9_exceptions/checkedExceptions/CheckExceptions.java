package com.onepieceofjava.day9_exceptions.checkedExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckExceptions {

   //read file
//    public static void readFile(String path) throws FileNotFoundException {
//        File file = new File(path);
//        new Scanner(file);
//    }
   public static void readFile(String path) {

       File file = new File(path);
       try{
           new Scanner(file);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }

   }


    //connect to database
    public static void connectToDatabase(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sampleDb","user","admin");
        }catch (SQLException e){
            System.out.println("Database connection failed: " + e.getMessage());
        }finally {
            System.out.println("Closing the database");
        }
    }
}
