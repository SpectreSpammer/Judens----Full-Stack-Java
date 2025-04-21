package com.onepieceofjava.day8_oop.answerForTheAssignment;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<EmployeeAbstract> employees = new ArrayList<>();



    public void addEmployee(EmployeeAbstract employee) {
        employees.add(employee);


    }

    public void addEmployee(String name, int id, double baseSalary) {
        employees.add(new Intern(name, id, baseSalary, "General"));
    }

    public void addEmployee(String name, int id, double baseSalary, String department) {
        if (department.equalsIgnoreCase("manager")) {
            employees.add(new Manager(name, id, baseSalary));
        } else if (department.equalsIgnoreCase("developer")) {
            employees.add(new Developer(name, id, baseSalary));
        } else {
            employees.add(new Intern(name, id, baseSalary, department));
        }
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(e -> e.getId() == employeeId);
    }

    public EmployeeAbstract getEmployee(int employeeId) {
        return employees.stream().filter(e -> e.getId() == employeeId).findFirst().orElse(null);
    }

    public List<EmployeeAbstract> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public void displayEmployeeInfo(EmployeeAbstract employee) {
        employee.displayInfo();
    }


}
