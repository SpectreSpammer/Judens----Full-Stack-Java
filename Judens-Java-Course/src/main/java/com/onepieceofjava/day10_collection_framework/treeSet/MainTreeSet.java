package com.onepieceofjava.day10_collection_framework.treeSet;

import com.onepieceofjava.day10_collection_framework.linkedlist.EmployeeLinkedList;

import java.util.Comparator;

public class MainTreeSet {
    public static void main(String[] args) {

        EmployeeServiceTreeSet employeeById = new EmployeeServiceTreeSet();
        employeeById.addEmployeeObject(new EmployeeTreeSet(1,"Judens","IT"));
        employeeById.addEmployeeObject(new EmployeeTreeSet(5,"Nan","Security"));
        employeeById.addEmployeeObject(new EmployeeTreeSet(3,"Nami","HR"));
        employeeById.addEmployeeObject(new EmployeeTreeSet(2,"Robin","PR"));
        employeeById.addEmployeeObject(new EmployeeTreeSet(4,"Sanji","Kitchen"));
        employeeById.addEmployeeObject(new EmployeeTreeSet(1,"Judens","IT"));

        System.out.println("--- Sorting of Employees by Id---");
        employeeById.printAllEmployees();
        System.out.println();

        System.out.println("First Employee: " + employeeById.getFirstEmployee());
        System.out.println("Last Employee: " + employeeById.getLastEmployee());
        System.out.println();


        EmployeeServiceTreeSet employeeByName = new EmployeeServiceTreeSet(
                Comparator.comparing(EmployeeTreeSet::getName)
        );
        employeeByName.addEmployeeObject(new EmployeeTreeSet(1,"Judens","IT"));
        employeeByName.addEmployeeObject(new EmployeeTreeSet(5,"Nan","Security"));
        employeeByName.addEmployeeObject(new EmployeeTreeSet(3,"Nami","HR"));
        employeeByName.addEmployeeObject(new EmployeeTreeSet(2,"Robin","PR"));
        employeeByName.addEmployeeObject(new EmployeeTreeSet(4,"Sanji","Kitchen"));
        employeeByName.addEmployeeObject(new EmployeeTreeSet(1,"Judens","IT"));
        System.out.println("--- Sorting of Employees by Name---");
        employeeByName.printAllEmployees();
        System.out.println();

        EmployeeServiceTreeSet employeeByDept = new EmployeeServiceTreeSet(
                Comparator.comparing(EmployeeTreeSet::getDepartment)
        );
        employeeByDept.addEmployeeObject(new EmployeeTreeSet(1,"Judens","IT"));
        employeeByDept.addEmployeeObject(new EmployeeTreeSet(5,"Nan","Security"));
        employeeByDept.addEmployeeObject(new EmployeeTreeSet(3,"Nami","HR"));
        employeeByDept.addEmployeeObject(new EmployeeTreeSet(2,"Robin","PR"));
        employeeByDept.addEmployeeObject(new EmployeeTreeSet(4,"Sanji","Kitchen"));
        employeeByDept.addEmployeeObject(new EmployeeTreeSet(1,"Judens","IT"));
        System.out.println("--- Sorting of Employees by Name---");
        employeeByDept.printAllEmployees();
        System.out.println();
    }
}
