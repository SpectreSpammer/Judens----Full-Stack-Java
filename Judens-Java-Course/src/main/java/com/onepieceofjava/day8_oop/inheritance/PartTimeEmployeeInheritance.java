package com.onepieceofjava.day8_oop.inheritance;

public class PartTimeEmployeeInheritance extends EmployeeInheritance{

    private double overTimePay;
    private int hoursWorked;
    public PartTimeEmployeeInheritance(int id, String name, double salary, double overTimePay,int hoursWorked) {
        super(id, name, salary);
        this.overTimePay = overTimePay;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + (overTimePay * hoursWorked);
    }

    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("overTimePay: Php" + overTimePay);
        System.out.println("hoursWorked: Php" + hoursWorked);
    }
}
