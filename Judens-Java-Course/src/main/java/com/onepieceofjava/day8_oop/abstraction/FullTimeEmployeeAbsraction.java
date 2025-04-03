package com.onepieceofjava.day8_oop.abstraction;

public class FullTimeEmployeeAbsraction extends EmployeeAbstration{
    private double bonus;
    public FullTimeEmployeeAbsraction(int id, String name, double salary,double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }
}
