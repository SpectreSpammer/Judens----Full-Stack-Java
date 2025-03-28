package com.onepieceofjava.day7_methods.methods;

public class mainMethods {
    public static void main(String[] args) {

        displayEmployeeInfo("Judens", 30);

        double salary = calculateSalary(9, 550.5);
        System.out.println("Your daily income is " + salary);

        double bonus = calculateSalary(50000.75,3);
        System.out.println("Your bonus is: " + bonus);

        System.out.println("Your bonus is " + calculateSalary(50000.75,"good"));

    }

    private static double calculateSalary(int workingHours, double hourlyRate) {
        return  workingHours * hourlyRate;
    }

    private static double calculateSalary( double salary, int yearsOfService) {
        return  yearsOfService * salary;
    }

    private static String calculateSalary( double salary, String performanceRating) {

        double percentageBonus;
        switch (performanceRating){
            case "excellent":
                percentageBonus = 0.1;
                break;
            case "good":
                percentageBonus = 0.05;
                break;
            default:
                percentageBonus = 0.03;
                performanceRating = "average";

        }

        double bonusAmount = salary * percentageBonus;
        return String.format("Judens got a bonus of Php: %.2f, Performance Rating: ",
                                        bonusAmount,                    performanceRating);
    }

    private static void displayEmployeeInfo(String name, int age) {
        System.out.println(" Name: " + name);
        System.out.println("Age: " + age);
    }
}
