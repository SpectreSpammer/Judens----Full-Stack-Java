package com.onepieceofjava.javaBackendAssessment.model;

import java.util.Set;

public class ManagerAssessment extends EmployeeAssessment {

    public ManagerAssessment(int id, String firstName, String lastName, String department,
                             int yearsOfService, double salary, Set<String> benefits, double bonus) {
        super(id, firstName, lastName, department, yearsOfService, salary, benefits, bonus);
    }

    @Override
    public double calculateTotalCompensation() {
        return salary + bonus;
    }
}
