package com.onepieceofjava.day8_oop.abstraction;

public abstract class EmployeeAbstration {
    private int id;
    private String name;
    protected double salary;

    public EmployeeAbstration(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateSalary();

    public void displayEmployeeInfo(){
        System.out.println("Id:" + id);
        System.out.println("Name:" + name);
        System.out.println("Salary:" + salary);

    }
}
