package com.onepieceofjava.javaBackendAssessment.model;

import java.util.Objects;
import java.util.Set;

 public abstract class EmployeeAssessment implements Comparable<EmployeeAssessment> {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String department;
    protected int yearsOfService;
    protected double salary;
    protected Set<String> benefits;
    protected double bonus;

    public EmployeeAssessment(int id, String firstName, String lastName, String department,
                              int yearsOfService, double salary, Set<String> benefits, double bonus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.yearsOfService = yearsOfService;
        this.salary = salary;
        this.benefits = benefits;
        this.bonus = bonus;
    }

    // Abstract method (OOP: Polymorphism)
    public abstract double calculateTotalCompensation();

    // Getters and setters (OOP: Encapsulation)
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public double getSalary() {
        return salary;
    }

    public Set<String> getBenefits() {
        return benefits;
    }

    public double getBonus() {
        return bonus;
    }


     @Override
     public String toString() {
         return "EmployeeAssessment{" +
                 "id=" + id +
                 ", firstName='" + firstName + '\'' +
                 ", lastName='" + lastName + '\'' +
                 ", department='" + department + '\'' +
                 ", yearsOfService=" + yearsOfService +
                 ", salary=" + salary +
                 ", benefits=" + benefits +
                 ", bonus=" + bonus +
                 '}';
     }

     @Override
    public int compareTo(EmployeeAssessment other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAssessment employeeAssessment = (EmployeeAssessment) o;
        return id == employeeAssessment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
