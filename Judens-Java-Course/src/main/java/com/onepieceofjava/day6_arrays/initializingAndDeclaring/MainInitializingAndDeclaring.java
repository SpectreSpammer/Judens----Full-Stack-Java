package com.onepieceofjava.day6_arrays.initializingAndDeclaring;

public class MainInitializingAndDeclaring {
    public static void main(String[] args) {

        // datatype[] + variablename = {value}
        String [] employeeNames = {"judens","nan","nami","robin"};

        System.out.println("List of employees");
        for( String names: employeeNames){
            System.out.println(" - " + names);
        }

        System.out.println("Employee Information:");
        for(int i= 0; i < employeeNames.length;i++ ){
            String name = employeeNames[i];
            System.out.println("Name: " + name);
        }
    }
}
