package com.onepieceofjava.day8_oop.inheritance;

public class EmployeeInheritance {
    private int id;
    private String name;
    private double salary;

    public EmployeeInheritance(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public double calculateSalary(){
        return salary;
    }

    public void displayEmployeeInfo(){
        System.out.println("Id:" + id);
        System.out.println("Name:" + name);
        System.out.println("Salary:" + salary);
        System.out.println("Total Salary:" + calculateSalary());

    }

}
