package com.onepieceofjava.day8_oop.encapsulation;

public class EmployeeEncapsulation {

    private int id;
    private String name;
    private double salary;


    public EmployeeEncapsulation(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if( salary > 0){
            this.salary = salary;
        }else {
            System.out.println("Salary must be greater than zero.");
        }
    }

    public void salaryIncreaseByPercentage(double percentage){
        if( percentage > 0){
            this.salary *= ( percentage / 10) ;

            System.out.println();
            System.out.println(name + " received a " + percentage + " % raise.");
        }else {
            System.out.println("Percentage must be greater than zero.");
        }
    }
}
