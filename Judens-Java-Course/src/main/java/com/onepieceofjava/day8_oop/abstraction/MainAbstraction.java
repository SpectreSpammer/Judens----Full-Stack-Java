package com.onepieceofjava.day8_oop.abstraction;

public class MainAbstraction {
    public static void main(String[] args) {

        EmployeeAbstration fte = new FullTimeEmployeeAbsraction(1,"judens",50000,23500);
        EmployeeAbstration pt = new PartTimeEmployeeAbsraction(2,"nan",60000,3500,3);

        fte.displayEmployeeInfo();
        System.out.println("Total salary for FTE: " + fte.calculateSalary());
        System.out.println();
        pt.displayEmployeeInfo();
        pt.calculateSalary();
        System.out.println("Total salary for PT: " + pt.calculateSalary());
    }
}
