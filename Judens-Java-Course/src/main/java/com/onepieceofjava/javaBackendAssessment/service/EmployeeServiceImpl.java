package com.onepieceofjava.javaBackendAssessment.service;



import com.onepieceofjava.javaBackendAssessment.exception.DuplicateEmployeeException;
import com.onepieceofjava.javaBackendAssessment.exception.EmployeeNotFoundException;
import com.onepieceofjava.javaBackendAssessment.model.DeveloperAssessment;
import com.onepieceofjava.javaBackendAssessment.model.EmployeeAssessment;
import com.onepieceofjava.javaBackendAssessment.model.ManagerAssessment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class EmployeeServiceImpl {
    private Map<Integer, EmployeeAssessment> employeeMap;

    private Set<EmployeeAssessment> employeeSet;

    private List<EmployeeAssessment> employeeList;

    public EmployeeServiceImpl() {
        employeeMap = new HashMap<>();
        employeeSet = new TreeSet<>();
        employeeList = new LinkedList<>();
    }

    public void addEmployee(EmployeeAssessment employee) throws DuplicateEmployeeException {
        if (employeeMap.containsKey(employee.getId())) {
            throw new DuplicateEmployeeException("EmployeeAssessment with ID " + employee.getId() + " already exists.");
        }
        employeeMap.put(employee.getId(), employee);
        employeeSet.add(employee);
        employeeList.add(employee);
    }

    public EmployeeAssessment getEmployee(int id) throws EmployeeNotFoundException {
        EmployeeAssessment employee = employeeMap.get(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("EmployeeAssessment with ID " + id + " not found.");
        }
        return employee;
    }

    public void removeEmployee(int id) throws EmployeeNotFoundException {
        EmployeeAssessment employee = getEmployee(id);
        employeeMap.remove(id);
        employeeSet.remove(employee);
        employeeList.remove(employee);
    }

    // File I/O: Reading from Excel
    public void loadEmployeesFromExcel(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Excel file not found. Creating a new one.");
            createEmptyExcelFile(filename);
            return; // No employees to load, so we return
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                try {
                    EmployeeAssessment employee = createEmployeeFromRow(row);
                    addEmployee(employee);
                } catch (DuplicateEmployeeException e) {
                    System.err.println("Warning: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error reading row: " + e.getMessage());
                }
            }
        }
    }

    //create excel file if empty
    private void createEmptyExcelFile(String filename) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"EmployeeAssessment Id", "First Name", "Last Name", "Department", "Years of Service", "Salary", "Benefits", "Bonus", "Total Compensation"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Auto-size columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to file
            try (FileOutputStream fileOut = new FileOutputStream(filename)) {
                workbook.write(fileOut);
            }
        }
    }

    //create employee
    public void addSpecificEmployeeAndWriteToExcel(String filename) throws IOException {
        // Create the specific employees
        EmployeeAssessment newEmployee = new DeveloperAssessment(
                1,
                "Mugiwara",
                "Boy",
                "IT",
                20,
                500000.0,
                new HashSet<>(Collections.singletonList("Free Travel whole World")),
                250000.0
        );
        EmployeeAssessment managerEmployee = new ManagerAssessment(
                2,
                "Strawhat",
                "Luffy",
                "Sales",
                10,
                50000.0,
                new HashSet<>(Collections.singletonList("Free Car worth 1 million")),
                50000.0
        );

        EmployeeAssessment judens = new ManagerAssessment(
                3,
                "Judens",
                "Bandal",
                "Security",
                15,
                150000.0,
                new HashSet<>(Collections.singletonList("Free Car worth 3 million")),
                70000.0
        );

        List<EmployeeAssessment> employeesToAdd = new ArrayList<>();

        // Try to add employees to the internal data structure
        try {
            addEmployee(newEmployee);
            employeesToAdd.add(newEmployee);
        } catch (DuplicateEmployeeException e) {
            System.err.println("Warning: " + e.getMessage());
        }

        try {
            addEmployee(managerEmployee);
            employeesToAdd.add(managerEmployee);
        } catch (DuplicateEmployeeException e) {
            System.err.println("Warning: " + e.getMessage());
        }

        try {
            addEmployee(judens);
            employeesToAdd.add(judens);
        } catch (DuplicateEmployeeException e) {
            System.err.println("Warning: " + e.getMessage());
        }

        // If no new employees to add, exit the method
        if (employeesToAdd.isEmpty()) {
            System.out.println("No new employees to add. Exiting method.");
            return;
        }

        // Check if file exists, if not create it
        File file = new File(filename);
        if (!file.exists()) {
            createEmptyExcelFile(filename);
        }

        // Read existing data or create new workbook
        Workbook workbook;
        try (FileInputStream fis = new FileInputStream(file)) {
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            workbook = new XSSFWorkbook();
        }

        Sheet sheet = workbook.getSheet("Employees");
        if (sheet == null) {
            sheet = workbook.createSheet("Employees");
            // Create header row if it's a new sheet
            Row headerRow = sheet.createRow(0);
            String[] columns = {"EmployeeAssessment Id", "First Name", "Last Name", "Department", "Years of Service", "Salary", "Benefits", "Bonus", "Total Compensation"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }
        }

        // Find the next available row
        int rowNum = sheet.getLastRowNum() + 1;

        // Add new employees
        for (EmployeeAssessment employee : employeesToAdd) {
            Row newRow = sheet.createRow(rowNum++);
            fillEmployeeRow(newRow, employee);
            formatEmployeeRow(newRow, employee);
        }

        // Auto-size columns
        for (int i = 0; i < 9; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to file
        try (FileOutputStream fileOut = new FileOutputStream(filename)) {
            workbook.write(fileOut);
        }

        // Close the workbook to release resources
        workbook.close();

        System.out.println("Added " + employeesToAdd.size() + " new employee(s) to the Excel file.");
    }

    private void formatEmployeeRow(Row row, EmployeeAssessment employee) {
        // Format Salary and Bonus cells
        Cell salaryCell = row.getCell(5);
        Cell bonusCell = row.getCell(7);
        salaryCell.setCellValue("Php " + employee.getSalary());
        bonusCell.setCellValue("Php " + employee.getBonus());

        // Add Total Compensation
        Cell totalCompCell = row.createCell(8);
        totalCompCell.setCellValue("Php " + employee.calculateTotalCompensation());
    }


    private EmployeeAssessment createEmployeeFromRow(Row row) {
        int id = getCellValueAsInt(row.getCell(0));
        String firstName = row.getCell(1).getStringCellValue();
        String lastName = row.getCell(2).getStringCellValue();
        String department = row.getCell(3).getStringCellValue();
        int yearsOfService = getCellValueAsInt(row.getCell(4));
        double salary = getCellValueAsDouble(row.getCell(5));
        Set<String> benefits = new HashSet<>(Arrays.asList(row.getCell(6).getStringCellValue().split(",")));
        double bonus = getCellValueAsDouble(row.getCell(7));

        if (department.equalsIgnoreCase("Management")) {
            return new ManagerAssessment(id, firstName, lastName, department, yearsOfService, salary, benefits, bonus);
        } else {
            return new DeveloperAssessment(id, firstName, lastName, department, yearsOfService, salary, benefits, bonus);
        }
    }

    private int getCellValueAsInt(Cell cell) {
        try {
            return (int) cell.getNumericCellValue();
        } catch (IllegalStateException e) {
            return Integer.parseInt(cell.getStringCellValue().replaceAll("[^0-9]", ""));
        }
    }

    private double getCellValueAsDouble(Cell cell) {
        try {
            return cell.getNumericCellValue();
        } catch (IllegalStateException e) {
            return Double.parseDouble(cell.getStringCellValue().replaceAll("[^0-9.]", ""));
        }
    }


    private void fillEmployeeRow(Row row, EmployeeAssessment employee) {
        row.createCell(0).setCellValue(employee.getId());
        row.createCell(1).setCellValue(employee.getFirstName());
        row.createCell(2).setCellValue(employee.getLastName());
        row.createCell(3).setCellValue(employee.getDepartment());
        row.createCell(4).setCellValue(employee.getYearsOfService());
        row.createCell(5).setCellValue(employee.getSalary());
        row.createCell(6).setCellValue(String.join(",", employee.getBenefits()));
        row.createCell(7).setCellValue(employee.getBonus());
    }



    public void displayAllEmployees() {
        for (EmployeeAssessment employee : employeeList) {
            System.out.println(employee);
        }
    }
}
