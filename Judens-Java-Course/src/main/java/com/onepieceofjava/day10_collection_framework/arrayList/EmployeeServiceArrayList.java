package com.onepieceofjava.day10_collection_framework.arrayList;

import java.util.ArrayList;

public class EmployeeServiceArrayList {

    private ArrayList<EmployeeArrayList> employeeList;

    public EmployeeServiceArrayList() {
        employeeList = new ArrayList<>();
    }

    //CRUD

    //GET LAST
    public EmployeeArrayList getLastEmployee(){
        return employeeList.getLast();
    }

    //GET FIRST
    public EmployeeArrayList getFirstEmployee(){
        return employeeList.getFirst();
    }

    //GET FIRST
    public EmployeeArrayList getEmployeeIdByIndex(int employeeId){
        return employeeList.get(employeeId);
    }

    //ADD OBJECT
    public void addEmployeeByIndex(EmployeeArrayList addEmployee){
        employeeList.add(addEmployee);
    }

    //ADD BY INDEX
    public void addEmployeeByIndex(int index, EmployeeArrayList addEmployeeByIndex){
        employeeList.add(index,addEmployeeByIndex);
    }

    //ADD FIST
    public void addEmployeeByFirst(EmployeeArrayList addEmployee){
        employeeList.addFirst(addEmployee);
    }

    //ADD LAST
    public void addEmployeeByLast(EmployeeArrayList addEmployee){
        employeeList.addLast(addEmployee);
    }

    //update
    public void updateEmployee(int index, EmployeeArrayList addEmployeeByIndex){
        employeeList.set(index,addEmployeeByIndex);
    }

    //remove
    public EmployeeArrayList removeEmployeeIdByIndex(int employeeId){
        return employeeList.remove(employeeId);
    }

    //total
    public int getTotalNoOfEmployees(){
        return employeeList.size();
    }

    //empty
    public boolean isEmpty(){
        return employeeList.isEmpty();
    }

    public void printAllEmployeees(){
        for(EmployeeArrayList emp : employeeList){
            System.out.println(" - "  + emp);
        }
    }
}
