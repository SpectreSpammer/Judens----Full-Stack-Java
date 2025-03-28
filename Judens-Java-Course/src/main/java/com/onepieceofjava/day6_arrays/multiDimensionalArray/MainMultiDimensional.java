package com.onepieceofjava.day6_arrays.multiDimensionalArray;

public class MainMultiDimensional {
    public static void main(String[] args) {

        Object[][] employeeData = {
                {"Judens",50000.8532, 9,false},
                {"Nan",60000.8545, 11,true},
                {"Nami",70000.8521, 3,true},
                {"Robin",80000.85231, 15,false},
        };

        displayEmployeeData(employeeData);

        //10% raise to all employees > 10 yearsOfService
        System.out.println("Applying 10% raise to all employees > 10 yearsOfService");
        for(int i=0; i < employeeData.length; i++){
            if((int)employeeData[i][2] > 10){
                double originalSalary = (double) employeeData[i][1];
                employeeData[i][1] = (double) employeeData[i][1] *1.10;
                System.out.printf(" %s received a 10%% raise, Original Salary: Php %.4f, New Salary: %.2f %n,",
                        employeeData[i][0],           originalSalary,                 employeeData[i][1] );
                /*
                        -- format function
                    %s -> String format
                    %.2f -> double/float decimal places
                    %n -> new line
                    %d -> int
                 */
            }
        }
    }

    private static void displayEmployeeData(Object[][] employeeData) {
        for(Object[] employees : employeeData){
            System.out.println("Name: " + employees[0]);
            System.out.println("Salary: " + employees[1]);
            System.out.println("Years of Service: " + employees[2]);
            System.out.println("Is Late? : " + employees[3]);
            System.out.println();

        }
    }
}
