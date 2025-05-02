package com.onepieceofjava.day11_FileIO;

import java.io.*;
import java.util.logging.Logger;

public class MainDeserialization {
    public static void main(String[] args) {


        Logger LOGGER = Logger.getLogger(MainDeserialization.class.getName());
        EmployeeIO employeeIO = null;


        try{
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Mugiwara\\Downloads\\Test\\Judens bandal.xlsx");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            employeeIO = (EmployeeIO) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Reading Judens bandal.txt....");
            LOGGER.info("File Judens Bandal.txt is reading Successfully..");

            System.out.println("Full Name: " + employeeIO.name);
            System.out.println("Address: " + employeeIO.address);

        }catch (ClassNotFoundException |  IOException e){
            e.printStackTrace();
            System.out.println("Error in reading a file....");
        }
    }
}
