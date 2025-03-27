package com.onepieceofjava.day5_control_flow.loopStatement;

public class MainForLoop {
    public static void main(String[] args) {

        String [] employeeNames = {"judens","nan","nami","robin"};
        double [] salary = {40000,50000,60000,70000};
        int [] yearsOfService = { 6,3,5,9};


        System.out.println("Employee Information:");
        for(int i= 0; i < employeeNames.length;i++ ){
            String name = employeeNames[i];
            double baseSalary = salary[i];
            int years  = yearsOfService[i];

            System.out.println("Name: " + name);
            System.out.println("Salary: " + baseSalary);
            System.out.println("Year: " + years);
            System.out.println();
        }
    }
}
