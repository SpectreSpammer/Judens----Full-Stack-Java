package com.onepieceofjava.day9_exceptions.customizeException;

public class MainCustomizeException {
    public static void main(String[] args){

        EmployeeException employee = new EmployeeException("judens",50000.75);

        try{
            employee.raiseSalary(10);
            System.out.println("10% raise successful");

            employee.raiseSalary(-10);
            System.out.println("this line should not be printed");
        } catch (InvalidRaiseException e) {
            System.out.println("Caught the error: " + e.getMessage());
        }finally {
            System.out.println("Salary processing is completed");
        }

    }
}
