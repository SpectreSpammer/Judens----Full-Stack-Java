package com.onepieceofjava.day10_collection_framework.hashSet;

import java.util.HashSet;

public class EmployeeServiceHashSets {

    private HashSet<EmployeeHashSet> employeeHashSets;

    public EmployeeServiceHashSets() {
        employeeHashSets = new HashSet<>();
    }

    //add
    public boolean addEmployee(EmployeeHashSet addEmployee){
        return employeeHashSets.add(addEmployee);

    }

    //remove
    public boolean removeEmployee(EmployeeHashSet removeEmployee){
        return employeeHashSets.remove(removeEmployee);

    }

    //validate if the object is exist or contains
    public boolean containsEmployee(EmployeeHashSet containsEmployee){
        return employeeHashSets.contains(containsEmployee);

    }

    //size
    public int getTotalNoOfEmployees(){
        return employeeHashSets.size();
    }

    //print
    public void printAllEmployees(){
        System.out.println("Current employees");
        for(EmployeeHashSet emp: employeeHashSets){
            System.out.println(" - " + emp);
        }
    }


}
