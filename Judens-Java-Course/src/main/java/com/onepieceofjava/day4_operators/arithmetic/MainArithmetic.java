package com.onepieceofjava.day4_operators.arithmetic;

public class MainArithmetic {
    public static void main(String[] args) {


        double salary = 50000.85;
        double bonus = 25000.75;
        double tax = 10000.75;
        double hourlyRate = 1500.85;
        int workingHours = 9;
        int yearsOfExperience = 5;

        //addition
        double grossPay = salary + bonus;
        System.out.println("1. Addition");
        System.out.println(" - Gross Pay: " + grossPay);

        //substraction
        double netpay = grossPay - tax;
        System.out.println("2. Subtraction");
        System.out.println(" - Net Pay: " + netpay);

        //multiplcation
        double dailyIncome = hourlyRate * workingHours;
        System.out.println("3. Multiplication");
        System.out.println(" - Daily Income Pay: " + dailyIncome);

        //division
        double averageSalaryIncrease = salary / yearsOfExperience;
        System.out.println("4. Division");
        System.out.println(" - Average Salary Increase: " + averageSalaryIncrease);

        //modulus
        double averageIncrease = salary % yearsOfExperience;
        System.out.println("5. Modulus");
        System.out.println(" - Average Salary Increase: " + averageIncrease);
    }
}
