package com.onepieceofjava.day8_oop.inheritance;

public class MainInheritance {

    public static void main(String[] args) {

        EmployeeInheritance regularEmployee = new EmployeeInheritance(201,"judens",50000.75);
        FullTimeEmployeeInheritance fte = new FullTimeEmployeeInheritance(202,"nan",50000.75,25000.75);
        PartTimeEmployeeInheritance pt = new PartTimeEmployeeInheritance(203,"nami",50000.75,1500,4);

        System.out.println("Regular Employee");
        regularEmployee.displayEmployeeInfo();
        regularEmployee.calculateSalary();
        System.out.println();
        System.out.println("Full Time Employee");
        fte.displayEmployeeInfo();
        fte.calculateSalary();
        System.out.println();
        System.out.println("Part time Employee");
        pt.displayEmployeeInfo();
        pt.calculateSalary();
        System.out.println();
    }
}
