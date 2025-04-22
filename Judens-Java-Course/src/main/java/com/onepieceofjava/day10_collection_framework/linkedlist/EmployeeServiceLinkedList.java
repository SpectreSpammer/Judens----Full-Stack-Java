package com.onepieceofjava.day10_collection_framework.linkedlist;

import java.util.LinkedList;

public class EmployeeServiceLinkedList {

    private LinkedList<EmployeeLinkedList> employeeLinkedLists;

    public EmployeeServiceLinkedList() {
        employeeLinkedLists = new LinkedList<>();
    }


    //get last
    public EmployeeLinkedList getLastEmployee(){
        return employeeLinkedLists.getLast();
    }

    //get first
    public EmployeeLinkedList getFirstEmployee(){
        return employeeLinkedLists.getFirst();
    }

    //get by index
    public EmployeeLinkedList getEmployeeByIndex(int employeeId){
        return employeeLinkedLists.get(employeeId);
    }

    //add object
    public void addEmployee(EmployeeLinkedList addEmployee){
        employeeLinkedLists.add(addEmployee);
    }

    //add by index
    public void addEmployeeByIndex(int index,EmployeeLinkedList addEmployee){
        employeeLinkedLists.add(index,addEmployee);
    }

    //add first
    public void addEmployeeByFirstIndex(EmployeeLinkedList addEmployeeByFirstIndex){
        employeeLinkedLists.addFirst(addEmployeeByFirstIndex);
    }

    //add first
    public void addEmployeeByLastIndex(EmployeeLinkedList addEmployeeByLastIndex){
        employeeLinkedLists.addLast(addEmployeeByLastIndex);
    }

    //update
    public void updateEmployeeByIndex(int index,EmployeeLinkedList updateEmployee){
        employeeLinkedLists.set(index,updateEmployee);
    }

    //delete
    public void removeEmployeeByIndex(int index){
        employeeLinkedLists.remove(index);
    }

    //total
    public int getTotalNoOfEmployees(){
        return employeeLinkedLists.size();
    }

    //empty
    public boolean isEmpty(){
        return employeeLinkedLists.isEmpty();
    }

    //print
    public void printAllEmployees(){
        for(EmployeeLinkedList emp : employeeLinkedLists){
            System.out.println(" - " + emp);
        }
    }
}
