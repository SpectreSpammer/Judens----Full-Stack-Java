package com.onepieceofjava.day8_oop.answerForTheAssignment;

public class Developer extends EmployeeAbstract implements Trainable {
    public Developer(String name, int id, double baseSalary) {
        super(name, id, baseSalary, "Development");
    }

    @Override
    public double calculateSalary() {
        return baseSalary + 500;
    }

    @Override
    public void attendTraining() {
        System.out.println(name + " is attending a coding workshop.");
    }
}
