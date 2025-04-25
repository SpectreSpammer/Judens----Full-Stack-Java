package com.onepieceofjava.day10_collection_framework.hashSet;

import com.onepieceofjava.day10_collection_framework.arrayList.EmployeeArrayList;
import com.onepieceofjava.day10_collection_framework.arrayList.EmployeeServiceArrayList;

public class MainHashSets {
    public static void main(String[] args) {

        EmployeeServiceHashSets employeeService= new EmployeeServiceHashSets();


        EmployeeHashSet emp1 = new EmployeeHashSet(1,"Judens","IT");
        EmployeeHashSet emp2 = new EmployeeHashSet(5,"Nan","Security");
        EmployeeHashSet emp3 = new EmployeeHashSet(3,"Nami","HR");
        EmployeeHashSet emp4 =new EmployeeHashSet(2,"Robin","PR");
        EmployeeHashSet emp5 =new EmployeeHashSet(4,"Sanji","Kitchen");
        EmployeeHashSet emp6 =new EmployeeHashSet(1,"Judens","IT");


        System.out.println("After adding of employees");
        System.out.println("Added employee 1:" + employeeService.addEmployee(emp1));
        System.out.println("Aded employee 2:" + employeeService.addEmployee(emp2));
        System.out.println("Added employee 3:" + employeeService.addEmployee(emp3));
        System.out.println("Added employee 4:" + employeeService.addEmployee(emp4));
        System.out.println("Added employee 5:" + employeeService.addEmployee(emp5));
        System.out.println("Added employee 6:" + employeeService.addEmployee(emp6));
        System.out.println();


        employeeService.printAllEmployees();
        System.out.println();

        System.out.println("Total number of employees: " + employeeService.getTotalNoOfEmployees());
        System.out.println();

        System.out.println("Checking if the employeee is exist?");
        System.out.println("Contains employee 1:" + employeeService.containsEmployee(emp1));
        System.out.println("Contains employee 2:" + employeeService.containsEmployee(emp2));
        System.out.println("Contains employee 3:" + employeeService.containsEmployee(emp3));
        System.out.println("Contains employee 4:" + employeeService.containsEmployee(emp4));
        System.out.println("Contains employee 5:" + employeeService.containsEmployee(emp5));
        System.out.println("Contains employee 6:" + employeeService.containsEmployee(emp6));

        System.out.println();
        System.out.println("Removed employee 3:" + employeeService.removeEmployee(emp3));
        System.out.println();
        employeeService.printAllEmployees();

        System.out.println();
        System.out.println("Employee hashcode emp1:" + emp1.hashCode());
        System.out.println("Employee hashcode emp2:" + emp2.hashCode());
        System.out.println("Employee hashcode emp3:" + emp3.hashCode());
        System.out.println("Employee hashcode emp4:" + emp4.hashCode());
        System.out.println("Employee hashcode emp5:" + emp5.hashCode());
        System.out.println("Employee hashcode emp6:" + emp6.hashCode());


    }
}
