package com.onepieceofjava.day5_control_flow.decisionMaking;

public class MainSwitchStatement {
    public static void main(String[] args) {

        int yearsOfExperience = 5;

        switch (yearsOfExperience){
            case 0:
            case 1:
                System.out.println("Experience Level: Junior" );
                break;

            case 2:

            case 3:
                System.out.println("Experience Level: Intermediate" );
                break;

            case 4:
            case 5:
                System.out.println("Experience Level: Senior" );
                break;

            default:
                System.out.println("Experience Level: Expert" );
        }

        String dept = "iT";

        switch (dept.toLowerCase()){
            case "it":
                System.out.println("Dept: IT");
                break;
            case "pr":
                System.out.println("Dept: PR");
                break;
            case "hr":
                System.out.println("Dept: HR");
                break;
            default:
                System.out.println("Dept: Admin");
        }
    }
}
