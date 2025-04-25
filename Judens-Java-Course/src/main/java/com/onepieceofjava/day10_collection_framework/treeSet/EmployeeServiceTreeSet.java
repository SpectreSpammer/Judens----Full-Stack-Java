package com.onepieceofjava.day10_collection_framework.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class EmployeeServiceTreeSet {
    private TreeSet<EmployeeTreeSet> employeeTreeSets;

    public EmployeeServiceTreeSet() {
       employeeTreeSets = new TreeSet<>();
    }

    public EmployeeServiceTreeSet(Comparator<EmployeeTreeSet> comparator) {
        employeeTreeSets = new TreeSet<>(comparator);
    }

    //get first
    public EmployeeTreeSet getFirstEmployee(){
        return employeeTreeSets.getFirst();
    }

    //get last
    public EmployeeTreeSet getLastEmployee(){
        return employeeTreeSets.getLast();
    }

    //add object
    public boolean addEmployeeObject(EmployeeTreeSet  addEmployee){
        return employeeTreeSets.add(addEmployee);
    }


    //delete object
    public boolean removeEmployeeObject(EmployeeTreeSet removeEmployee){
        return employeeTreeSets.remove(removeEmployee);
    }

    //delete first
    public void removeFirstEmployee(){
        employeeTreeSets.removeFirst();
    }

    //delete last
    public void removeLastEmployee(){
        employeeTreeSets.removeLast();
    }

    //print
    public void printAllEmployees(){
        for(EmployeeTreeSet emp: employeeTreeSets){
            System.out.println(" - "  + emp);
        }
    }
}
