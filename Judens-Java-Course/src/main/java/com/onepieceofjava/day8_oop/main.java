package com.onepieceofjava.day8_oop;

import com.onepieceofjava.day8_oop.encapsulation.EmployeeEncapsulation;

public class main {
    public static void main(String[] args) {

        EmployeeEncapsulation judens = new EmployeeEncapsulation(101,"Judens",50000.75);

        System.out.println("Id: " + judens.getId());
        System.out.println("Name: " + judens.getName());
        System.out.println("Salary: " + judens.getSalary());

        System.out.println();
        judens.setName("judens bandal");
        judens.setId(102);
        System.out.println("Id: " + judens.getId());
        System.out.println("Name: " + judens.getName());

        System.out.println();
        judens.setSalary(65000.75);
        System.out.println("Salary: " + judens.getSalary());

        judens.setSalary(-10000.75);
        System.out.println("Updated Salary: " + judens.getSalary());

        judens.salaryIncreaseByPercentage(-10);
        System.out.println("Salary increase by 10");

        System.out.println();
        judens.salaryIncreaseByPercentage(20);
        System.out.println("Salary increase by 20");
    }
}
