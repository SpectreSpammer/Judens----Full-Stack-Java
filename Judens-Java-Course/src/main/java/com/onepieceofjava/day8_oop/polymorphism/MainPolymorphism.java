package com.onepieceofjava.day8_oop.polymorphism;

public class MainPolymorphism {
    public static void main(String[] args) {

        EmployeeInterface fte = new FullTimeEmployeePolymorphism(101,"judens",50000.75,25000);
        fte.displayEmployeeInfo();

        System.out.println();

        EmployeeInterface pt = new PartTimeEmployeePolymorphism(102,"nan",50000.75,2500, 3);
        pt.displayEmployeeInfo();
    }
}
