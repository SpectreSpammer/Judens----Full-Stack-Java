package com.onepieceofjava.day4_operators.comparison;

public class MainComparison {
    public static void main(String[] args) {
        double salary = 150000;
        double bonus = 25000.75;
        double tax = 10000.75;
        double hourlyRate = 3000;
        int workingHours = 9;
        int yearsOfExperience = 5;

        // ==
        if( yearsOfExperience == 10){
            System.out.println("Judens has been with the company for 10 yrs");
        }else {
            System.out.println("Judens has not with the company for 10 yrs");
        }


        //!=
        if(salary != 50000){
            System.out.println("Judens is not earning 100k");
        }else {
            System.out.println("Judens is earning 100k");
        }

        // <
        if(hourlyRate < 3000){
            System.out.println("Judens daily income is not 3k per hr");
        }else {
            System.out.println("Judens daily income is more than 3k per hr");
        }

        // <=
        // <
        if(hourlyRate <= 3000){
            System.out.println("Judens daily income is not 3k per hr");
        }else {
            System.out.println("Judens daily income is more than 3k per hr");
        }

        // >
        if(yearsOfExperience > 5){
            System.out.println("Judens is a senior developer.");
        }else {
            System.out.println("Judens is an average developer");
        }

        // >=
        if(yearsOfExperience >= 5){
            System.out.println("Judens is a senior developer.");
        }else {
            System.out.println("Judens is an average developer");
        }


    }
}
