package com.onepieceofjava.day8_oop.answerForTheAssignment;

public class Intern extends EmployeeAbstract implements Trainable {
    public Intern(String name, int id, double baseSalary, String department) {
        super(name, id, baseSalary,department);
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 0.5;
    }

    @Override
    public void attendTraining() {
        System.out.println(name + " is attending an orientation session.");
    }
}
