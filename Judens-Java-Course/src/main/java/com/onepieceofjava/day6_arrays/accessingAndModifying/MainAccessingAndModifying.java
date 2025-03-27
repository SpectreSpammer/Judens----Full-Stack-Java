package com.onepieceofjava.day6_arrays.accessingAndModifying;

public class MainAccessingAndModifying {
    public static void main(String[] args) {

        String [] employeeNames = {"judens","nan","nami","robin"};
        double [] salary = {40000,50000,60000,70000};
        int [] yearsOfService = { 11,3,15,9};
        boolean [] isLate ={ true,false,true,false};

        //for each
        System.out.println("List of employees");
        for( String names: employeeNames){
            System.out.println(" - " + names);
        }

        //for loop
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

        //10% raise to all employees > 10 yearsOfService
        System.out.println("Applying 10% raise to all employees > 10 yearsOfService");
        for(int i=0; i < yearsOfService.length; i++){
            if(yearsOfService[i] > 10){
                double originalSalary = salary[i];
                salary[i] *= 1.10;
                System.out.printf(" %s received a 10%% raise, Original Salary: Php %.2f, New Salary: %.2f %n,",
                                    employeeNames[i],           originalSalary,                 salary[i] );
            }
        }

        System.out.println();
        //10% deduction to all employees who are late
        System.out.println("Applying 10% deduction to all employees who are late");
        for(int i=0; i < employeeNames.length; i++){
            if(isLate[i]){
                double originalSalary = salary[i];
                salary[i] -= 1.90;
                System.out.printf(" %s was late, Original Salary: Php %.2f, New Salary: %.2f %n,",
                        employeeNames[i],           originalSalary,                 salary[i] );
            }
        }
    }
}
