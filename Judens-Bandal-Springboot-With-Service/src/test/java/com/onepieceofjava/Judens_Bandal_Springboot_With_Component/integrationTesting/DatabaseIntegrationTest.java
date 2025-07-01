package com.onepieceofjava.Judens_Bandal_Springboot_With_Component.integrationTesting;


import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.JudensBandalSpringbootWithServiceApplication;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Assets;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Employee;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JudensBandalSpringbootWithServiceApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
public class DatabaseIntegrationTest {

    @Autowired
    private InventoryService inventoryService;

    private Employee testEmployee;

    private Assets testAsset;

    @BeforeEach
    void setUp(){
        //test data
        testEmployee = new Employee(null,"Judens","IT");
        testAsset = new Assets(null,"Lenovo","IT Laptop","LNV12345");
    }

    //================================Employee====================

    //add
    @Test
    void shouldSaveEmployeeAndRetrieve(){
        //saved
        Employee savedEmployee = inventoryService.addEmployee(testEmployee);
        assertNotNull(savedEmployee.getId());

        //retrieved
        Optional<Employee> retrievedEmployee = inventoryService.getEmployeeById(savedEmployee.getId());
        assertTrue(retrievedEmployee.isPresent());
        assertEquals("Judens",retrievedEmployee.get().getName());
        assertEquals("IT",retrievedEmployee.get().getDepartment());
    }

    //get all
    @Test
    void shouldGetAllEmployees(){
        //saved
        inventoryService.addEmployee(testEmployee);
        inventoryService.addEmployee(new Employee(null,"nan","devops"));

        //retrieved
        List<Employee> employees = inventoryService.getAllEmployees();
        assertFalse(employees.isEmpty());
        assertTrue(employees.size() >=2);
    }

    //update
    @Test
    void shouldUpdateEmployee() {
        //save
        Employee savedEmployee = inventoryService.addEmployee(testEmployee);

        //update
        savedEmployee.setDepartment("Information Technology");
        Employee updatedEmployee = inventoryService.updateEmployee(savedEmployee.getId(), savedEmployee);

        //verify
        assertEquals("Information Technology", updatedEmployee.getDepartment());
        Optional<Employee> retrievedEmployee = inventoryService.getEmployeeById(savedEmployee.getId());
        assertTrue(retrievedEmployee.isPresent());
        assertEquals("Information Technology", retrievedEmployee.get().getDepartment());
    }

    //delete
    @Test
    void shouldDeleteEmployeeById(){
        //saved
        Employee savedEmployee = inventoryService.addEmployee(testEmployee);
        assertNotNull(savedEmployee.getId(),"Employees should have been saved with an Id");

        //delete
        inventoryService.deleteEmployeeById(savedEmployee.getId());

        //verify
        Optional<Employee> retrievedEmployee = inventoryService.getEmployeeById(savedEmployee.getId());
        assertFalse(retrievedEmployee.isPresent(),"Employee should not exist after deletion");
    }

    //==============================ASSETS


}
