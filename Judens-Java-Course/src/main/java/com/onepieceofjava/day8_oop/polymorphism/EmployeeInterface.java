package com.onepieceofjava.day8_oop.polymorphism;

public interface EmployeeInterface {

    int getId();
    String getName();
    double salary();
    double calculateSalary();

    default void displayEmployeeInfo(){
        System.out.println("Id:" + getId());
        System.out.println("Name:" + getName());
        System.out.println("Salary:" +  salary());
        System.out.println("Total Salary:" + calculateSalary());

    }
}
