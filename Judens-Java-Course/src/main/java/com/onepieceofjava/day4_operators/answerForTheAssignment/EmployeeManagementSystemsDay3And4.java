package com.onepieceofjava.day4_operators.answerForTheAssignment;

public class EmployeeManagementSystemsDay3And4 {
    public static void main(String[] args) {

        String name1 = "luffy";
        int age1 = 21;
        double ITsalary1 = 35000;

        String name2 = "boa";
        int age2 = 28;
        double ITsalary2 = 55000;

        String name3 = "garp";
        int age3 = 73;
        double adminSalary3 = 49000;

        String name4 = "sengoku";
        int age4 = 75;
        double HRsalary4 = 65000;

        //1. check for retirement
        //way 1
        /*
        boolean anyoneEligibleForRetirement = false;

        if (age1 >= 65) {
            anyoneEligibleForRetirement = true;
        } else if (age2 >= 65) {
            anyoneEligibleForRetirement = true;
        } else if (age3 >= 65) {
            anyoneEligibleForRetirement = true;
        } else if (age4 >= 65) {
            anyoneEligibleForRetirement = true;
        } else {
            anyoneEligibleForRetirement = false;
        }
        */

        //way 2 -> way better
        boolean anyoneEligibleForRetirement = (age1 >= 65 || age2 >= 65 || age3 >= 65 || age4 >= 65);


        System.out.println("1. Retirement Eligibility:");



        System.out.println("   Is anyone eligible for retirement? " + (anyoneEligibleForRetirement ? "Yes" : "No"));
        if (anyoneEligibleForRetirement) {
            System.out.println("   Employees eligible for retirement:");
            if (age1 >= 65) System.out.println("   - " + name1);
            if (age2 >= 65) System.out.println("   - " + name2);
            if (age3 >= 65) System.out.println("   - " + name3);
            if (age4 >= 65) System.out.println("   - " + name4);
        }

        if (anyoneEligibleForRetirement) {
            System.out.println("   Employees are not eligible for retirement:");
            if (age1 <= 65) System.out.println("   - " + name1);
            if (age2 <= 65) System.out.println("   - " + name2);
            if (age3 <= 65) System.out.println("   - " + name3);
            if (age4 <= 65) System.out.println("   - " + name4);
        }


        //Average salary per department
        System.out.println("2. Average Salary per Department");
        double averageSalaryInIT = (ITsalary1 + ITsalary2 ) / 2;
        System.out.println("   - IT:  Php " + averageSalaryInIT);
        double averageSalaryInAdmin = adminSalary3;
        System.out.println("   - Admin:  Php " + averageSalaryInAdmin);
        double averageSalaryInHR= HRsalary4;
        System.out.println("   - HR:  Php " + averageSalaryInHR);

        //Average age of the employees
        System.out.println("3. Average age of all employees");
        int averageAgeOfAllEmployees = ( age1 + age2 + age3 + age4 ) / 4;
        System.out.println("   - Average age:  " + averageAgeOfAllEmployees);

        //5% raise to all employees except with a salary of 50k
        System.out.println("4. 5% raise to all employees except with a salary of 50k");
        System.out.println("   - Before");
        System.out.printf("   - %s: %.2f PHP\n", name1, ITsalary1);
        System.out.printf("   - %s: %.2f PHP\n", name2, ITsalary2);
        System.out.printf("   - %s: %.2f PHP\n", name3, adminSalary3);
        System.out.printf("   - %s: %.2f PHP\n", name4, HRsalary4);
        System.out.println();
        System.out.println("   - After");
        if( ITsalary1 < 50000 )
            ITsalary1 *= 1.05;
        System.out.printf("   - %s: %.2f PHP\n", name1, ITsalary1);

        if( ITsalary2 < 50000 )
            ITsalary2 *= 1.05;
        System.out.printf("   - %s: %.2f PHP\n", name2, ITsalary2);

        if( adminSalary3 < 50000 )
            adminSalary3 *= 1.05;
        System.out.printf("   - %s: %.2f PHP\n", name3, adminSalary3);

        if( HRsalary4 < 50000 )
            HRsalary4 *= 1.05;
        System.out.printf("   - %s: %.2f PHP\n", name4, HRsalary4);

    }
}
