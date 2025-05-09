package com.onepieceofjava.javaBackendAssessment;





import com.onepieceofjava.javaBackendAssessment.exception.EmployeeNotFoundException;
import com.onepieceofjava.javaBackendAssessment.model.EmployeeAssessment;
import com.onepieceofjava.javaBackendAssessment.model.ManagerAssessment;
import com.onepieceofjava.javaBackendAssessment.service.EmployeeServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeServiceImpl ems = new EmployeeServiceImpl();
        String filePath = "C:\\Users\\Mugiwara\\Downloads\\Test\\Employees.xlsx";

        try {
            // Check if file exists
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Excel file not found. A new file will be created.");
            }

            // File I/O: Reading (or creating if not exists)
            System.out.println("Loading employees from Excel file: " + filePath);
            ems.loadEmployeesFromExcel(filePath);
            System.out.println("Employees loaded successfully.");

            // Display initial employees (if any)
            System.out.println("\nInitial Employees:");
            ems.displayAllEmployees();

            // Demonstrate getting an employee
            try {
                EmployeeAssessment emp = ems.getEmployee(1);
                System.out.println("\nFound employee: " + emp.getFirstName() + " " + emp.getLastName());
                System.out.println("Total compensation: Php " + emp.calculateTotalCompensation());
            } catch (EmployeeNotFoundException e) {
                System.out.println("\nNo employee found with ID 1. This is expected if the file was just created.");
            }

            // Adding specific employee with retry logic
            boolean success = false;
            int retries = 10;
            while (!success && retries > 0) {
                try {
                    System.out.println("\nAdding specific employee to Excel file.");
                    ems.addSpecificEmployeeAndWriteToExcel(filePath);
                    System.out.println("Specific employee added successfully.");
                    success = true;
                } catch (IOException e) {
                    System.out.println("Error accessing file. Retrying in 2 seconds...");
                    retries--;
                    Thread.sleep(2000); // Wait for 2 seconds before retrying
                }
            }

            if (!success) {
                System.out.println("Failed to add specific employee after multiple attempts.");
            }

            // Display updated employees
            System.out.println("\nUpdated Employees:");
            ems.loadEmployeesFromExcel(filePath); // Reload to reflect changes
            ems.displayAllEmployees();

            // Demonstrate exception handling for non-existent employee
            try {
                ems.getEmployee(999); // This should throw an EmployeeNotFoundException
            } catch (EmployeeNotFoundException e) {
                System.out.println("\nExpected Error: " + e.getMessage());
            }

            // Demonstrate NullPointerException handling
            try {
                List<EmployeeAssessment> list = null;
                list.add(new ManagerAssessment(0, "", "", "", 0, 0, null, 0)); // This will throw NullPointerException
            } catch (NullPointerException e) {
                System.out.println("\nCaught NullPointerException: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Operation was interrupted: " + e.getMessage());
        }
    }
}
