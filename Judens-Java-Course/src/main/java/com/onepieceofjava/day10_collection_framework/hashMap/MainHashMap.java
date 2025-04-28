package com.onepieceofjava.day10_collection_framework.hashMap;

import com.onepieceofjava.day10_collection_framework.hashSet.EmployeeHashSet;
import com.onepieceofjava.day10_collection_framework.hashSet.EmployeeServiceHashSets;

public class MainHashMap {
    public static void main(String[] args) {

        EmployeeServiceHashMap employeeService= new EmployeeServiceHashMap();

        employeeService.addEmployee(new EmployeeHashMap(1,"Judens","IT"));
        employeeService.addEmployee(new EmployeeHashMap(5,"Nan","Security"));
        employeeService.addEmployee(new EmployeeHashMap(3,"Nami","HR"));
        employeeService.addEmployee(new EmployeeHashMap(2,"Robin","PR"));
        employeeService.addEmployee(new EmployeeHashMap(4,"Sanji","Kitchen"));
        employeeService.addEmployee(new EmployeeHashMap(1,"Judens","IT"));

        System.out.println();
        employeeService.displayAllEmployees();


        System.out.println("Employee #2:");
        int searchId = 2;
        EmployeeHashMap emp = employeeService.getEmployeeById(searchId);
        System.out.println("Employee with an Id: " + searchId + ": " + emp);
        System.out.println();

        System.out.println("Update employee #1");
        employeeService.updateEmployeeById(1,"Judensss","Information Technology");
        System.out.println("After updating");
        employeeService.displayAllEmployees();
        System.out.println();

        System.out.println("Remove #3:");
        int remove = 3;
        employeeService.removeEmployeeById(remove);
        System.out.println("After removing: " + remove);
        employeeService.displayAllEmployees();
        System.out.println();

        System.out.println("Check if employee 3 is exist?");
        int checkId = 3;
        System.out.println("Does employee "  + checkId + " exist? " + employeeService.hasEmployee(3));
        System.out.println();

        System.out.println("Total # of employees: "  + employeeService.totalNoOfEmployees());


    }
}
