package com.onepieceofjava.day8_oop.answerForTheAssignment;

public class Manager extends EmployeeAbstract{


    public Manager(String name, int id, double baseSalary) {
        super(name, id, baseSalary, "Management");
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 1.2;
    }

    /*
    @Override
    public void attendTraining() {
        System.out.println(name + " is attending an orientation session.");
    }
    */
}
