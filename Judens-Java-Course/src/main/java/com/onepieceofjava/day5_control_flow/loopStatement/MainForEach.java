package com.onepieceofjava.day5_control_flow.loopStatement;

public class MainForEach {
    public static void main(String[] args) {

        String [] employeeNames = {"judens","nan","nami","robin"};


        System.out.println("List of employees");
        for( String names: employeeNames){
            System.out.println(" - " + names);
        }
    }
}
