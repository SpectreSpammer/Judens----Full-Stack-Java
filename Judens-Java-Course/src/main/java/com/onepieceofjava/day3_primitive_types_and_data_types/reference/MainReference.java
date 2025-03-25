package com.onepieceofjava.day3_primitive_types_and_data_types.reference;

public class MainReference {
    public static void main(String[] args) {

        Employee manager = new Manager();
        Employee developer = new Developer();
        Employee designer = new Designer();

        Employee[] employees = { manager,designer,developer};

        for(Employee employee: employees){
            employee.work();
            employee.lunch();
            employee.meeting();
            System.out.println();
        }
    }
}
