package com.onepieceofjava.day10_collection_framework.arrayList;

public class MainArrayList {
    public static void main(String[] args) {

        EmployeeServiceArrayList employees = new EmployeeServiceArrayList();
        employees.addEmployeeByIndex(new EmployeeArrayList(1,"Judens","IT"));
        employees.addEmployeeByIndex(new EmployeeArrayList(5,"Nan","Security"));
        employees.addEmployeeByIndex(new EmployeeArrayList(3,"Nami","HR"));
        employees.addEmployeeByIndex(new EmployeeArrayList(2,"Robin","PR"));
        employees.addEmployeeByIndex(new EmployeeArrayList(4,"Sanji","Kitchen"));
        employees.addEmployeeByIndex(new EmployeeArrayList(1,"Judens","IT"));

        System.out.println("----After adding of employees-----");
        employees.printAllEmployeees();
        System.out.println();
        employees.addEmployeeByFirst(new EmployeeArrayList(7,"luffy","Devops"));
        System.out.println("----After adding of employees in the first index-----");
        employees.printAllEmployeees();
        System.out.println();
        employees.addEmployeeByLast(new EmployeeArrayList(8,"chopper","Clinic"));
        System.out.println("----After adding of employees in the last index-----");
        employees.printAllEmployeees();
        System.out.println();
        employees.addEmployeeByIndex(4,new EmployeeArrayList(9,"brook","Art"));
        System.out.println("----After adding of employees in the 4th index-----");
        employees.printAllEmployeees();
        System.out.println();
        employees.updateEmployee(1,new EmployeeArrayList(10,"Judens","AWS"));
        employees.printAllEmployeees();
        System.out.println();
        employees.removeEmployeeIdByIndex(7);
        System.out.println("Removing 7th index");
        employees.printAllEmployeees();
        System.out.println();
        System.out.println("Total number of employees: "  + employees.getTotalNoOfEmployees());
        System.out.println("Is the employee empty?: "  + employees.isEmpty());
        System.out.println();
        System.out.println("First employee " + employees.getFirstEmployee());
        System.out.println("Last employee " + employees.getLastEmployee());
        System.out.println("Employee at index  : " + employees.getEmployeeIdByIndex(3));

    }
}
