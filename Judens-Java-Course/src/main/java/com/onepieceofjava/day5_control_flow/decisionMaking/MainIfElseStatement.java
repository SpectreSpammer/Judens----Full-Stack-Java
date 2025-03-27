package com.onepieceofjava.day5_control_flow.decisionMaking;

public class MainIfElseStatement {
    public static void main(String[] args) {
        double salary = 150000;
        int yearsOfExperience = 5;

        // && - BOTH ARE TRUE
        if( yearsOfExperience == 10 && salary > 50000){
            System.out.println("Judens has been with the company for 10 yrs and paid well");
        }else {
            System.out.println("Judens has not with the company for 10 yrs and underpaid");
        }


        // || ATLEAST 1 IS TRUE
        if( yearsOfExperience == 10 || salary > 50000){
            System.out.println("Judens has been with the company for 10 yrs and paid well");
        }else {
            System.out.println("Judens has not with the company for 10 yrs and underpaid");
        }
    }
}
