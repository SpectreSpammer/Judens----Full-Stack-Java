package com.onepieceofjava.day10_collection_framework.treeMap;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeServiceTreeMap {
    private TreeMap<Integer, EmployeeTreeMap> employeeTreeMap;

    public EmployeeServiceTreeMap() {
        employeeTreeMap = new TreeMap<>();
    }

    //ADD
    public EmployeeTreeMap addEmployee(EmployeeTreeMap addEmployee){
        return employeeTreeMap.put(addEmployee.getId(),addEmployee);
    }

    //Get employee by id
    public EmployeeTreeMap getEmployeeById(int id){
        return employeeTreeMap.get(id);
    }

    //Get employee by first entry
    public EmployeeTreeMap getFirstEmployee(){
        return employeeTreeMap.firstEntry().getValue();
    }

    //Get employee by last entry
    public EmployeeTreeMap getLastEmployee(){
        return employeeTreeMap.lastEntry().getValue();
    }

    //remove employee by id
    public EmployeeTreeMap removeEmployeeById(int id){
        return employeeTreeMap.remove(id);
    }

    //update
    public void updateEmployeeById(int id,String name, String dept){{
        if(employeeTreeMap.containsKey(id)){
            employeeTreeMap.put(id,new EmployeeTreeMap(id,name, dept));
        }
    }

    }

    //if the employee exist
    public boolean hasEmployee(int id){
        return employeeTreeMap.containsKey(id);
    }

    //total # of employees
    public int totalNoOfEmployees(){
        return employeeTreeMap.size();
    }

    //display
    public void displayAllEmployees(){
        for(Map.Entry<Integer,EmployeeTreeMap> entry : employeeTreeMap.entrySet()){
            System.out.println("Id: "  + entry.getKey() + " , Value: " + entry.getValue());
        }
    }


}
