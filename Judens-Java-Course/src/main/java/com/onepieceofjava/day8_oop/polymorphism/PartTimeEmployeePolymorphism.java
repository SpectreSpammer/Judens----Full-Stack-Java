package com.onepieceofjava.day8_oop.polymorphism;

public class PartTimeEmployeePolymorphism implements EmployeeInterface {


    private int id;
    private String name;
    private double salary;
    private double overTimePay;
    private int workingHours;

    public PartTimeEmployeePolymorphism(int id, String name, double salary, double overTimePay,int workingHours) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.overTimePay = overTimePay;
        this.workingHours = workingHours;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double salary() {
        return salary;
    }

    @Override
    public double calculateSalary() {
        return salary + (overTimePay * workingHours);
    }


}
