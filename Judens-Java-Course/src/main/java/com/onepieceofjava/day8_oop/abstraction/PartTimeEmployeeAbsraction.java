package com.onepieceofjava.day8_oop.abstraction;

public class PartTimeEmployeeAbsraction extends EmployeeAbstration{
    private double overTimePay;
    private int workingHours;
    public PartTimeEmployeeAbsraction(int id, String name, double salary, double overTimePay,int workingHours) {
        super(id, name, salary);
        this.overTimePay = overTimePay;
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary() {
        return salary + (overTimePay * workingHours);
    }
}
