package com.onepieceofjava.day10_collection_framework.linkedlist;

import com.onepieceofjava.day10_collection_framework.arrayList.EmployeeArrayList;

public class MainLinkedList {
    public static void main(String[] args) {
        EmployeeServiceLinkedList employees = new EmployeeServiceLinkedList();
        employees.addEmployee(new EmployeeLinkedList(1,"Judens","IT"));
        employees.addEmployee(new EmployeeLinkedList(5,"Nan","Security"));
        employees.addEmployee(new EmployeeLinkedList(3,"Nami","HR"));
        employees.addEmployee(new EmployeeLinkedList(2,"Robin","PR"));
        employees.addEmployee(new EmployeeLinkedList(4,"Sanji","Kitchen"));
        employees.addEmployee(new EmployeeLinkedList(1,"Judens","IT"));

        System.out.println("----After adding of employees-----");
        employees.printAllEmployees();
        System.out.println();
        employees.addEmployeeByFirstIndex(new EmployeeLinkedList(7,"luffy","Devops"));
        System.out.println("----After adding of employees in the first index-----");
        employees.printAllEmployees();
        System.out.println();
        employees.addEmployeeByLastIndex(new EmployeeLinkedList(8,"chopper","Clinic"));
        System.out.println("----After adding of employees in the last index-----");
        employees.printAllEmployees();
        System.out.println();
        employees.addEmployeeByIndex(4,new EmployeeLinkedList(9,"brook","Art"));
        System.out.println("----After adding of employees in the 4th index-----");
        employees.printAllEmployees();
        System.out.println();
        employees.updateEmployeeByIndex(1,new EmployeeLinkedList(10,"Judens","AWS"));
        employees.printAllEmployees();
        System.out.println();
        employees.removeEmployeeByIndex(7);
        System.out.println("Removing 7th index");
        employees.printAllEmployees();
        System.out.println();
        System.out.println("Total number of employees: "  + employees.getTotalNoOfEmployees());
        System.out.println("Is the employee empty?: "  + employees.isEmpty());
        System.out.println();
        System.out.println("First employee " + employees.getFirstEmployee());
        System.out.println("Last employee " + employees.getLastEmployee());
        System.out.println("Employee at index  : " + employees.getEmployeeByIndex(3));
    }
}
