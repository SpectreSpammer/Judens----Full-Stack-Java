package com.onepieceofjava.day10_collection_framework.hashMap;

import com.onepieceofjava.day10_collection_framework.treeMap.EmployeeTreeMap;

import java.util.HashMap;
import java.util.Map;

public class EmployeeServiceHashMap {
    private HashMap<Integer,EmployeeHashMap> employeeHashMap;

    public EmployeeServiceHashMap() {
       employeeHashMap = new HashMap<>();
    }

    //ADD
    public EmployeeHashMap addEmployee(EmployeeHashMap addEmployee){
        return employeeHashMap.put(addEmployee.getId(),addEmployee);
    }

    //Get employee by id
    public EmployeeHashMap getEmployeeById(int id){
        return employeeHashMap.get(id);
    }

    //remove employee by id
    public EmployeeHashMap removeEmployeeById(int id){
        return employeeHashMap.remove(id);
    }

    //update
    public void updateEmployeeById(int id,String name, String dept){{
        if(employeeHashMap.containsKey(id)){
            employeeHashMap.put(id,new EmployeeHashMap(id,name, dept));
        }
    }

    }

    //if the employee exist
    public boolean hasEmployee(int id){
        return employeeHashMap.containsKey(id);
    }

    //total # of employees
    public int totalNoOfEmployees(){
        return employeeHashMap.size();
    }

    //display
    public void displayAllEmployees(){
        for(Map.Entry<Integer,EmployeeHashMap> entry : employeeHashMap.entrySet()){
            System.out.println("Id: "  + entry.getKey() + " , Value: " + entry.getValue());
        }
    }


}
