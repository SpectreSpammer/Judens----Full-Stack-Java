package com.onepieceofjava.day11_FileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

public class MainSerialization {
    public static void main(String[] args) {


        Logger LOGGER = Logger.getLogger(MainSerialization.class.getName());
        EmployeeIO employeeIO = new EmployeeIO();
        employeeIO.name = "Judens";
        employeeIO.address = "Visayas";

        try{
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Mugiwara\\Downloads\\Test\\Judens bandal.xlsx");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employeeIO);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Creating Judens bandal.txt is created successfully");
            LOGGER.info("File Judens Bandal.txt is created Successfully..");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error in writing a file....");
        }
    }
}
