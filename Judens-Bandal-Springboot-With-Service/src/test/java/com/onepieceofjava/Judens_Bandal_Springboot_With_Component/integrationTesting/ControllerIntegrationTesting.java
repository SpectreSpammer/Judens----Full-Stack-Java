package com.onepieceofjava.Judens_Bandal_Springboot_With_Component.integrationTesting;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.JudensBandalSpringbootWithServiceApplication;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Assets;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Employee;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = JudensBandalSpringbootWithServiceApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class ControllerIntegrationTesting {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private InventoryService inventoryService;

    private Employee testEmployee;

    private Assets testAssets;

    @BeforeEach
    void setUp(){
        //test data
        testEmployee = new Employee(null,"Judens","IT");

        testAssets = new Assets(null,"Lenovo","IT Laptop","LNV12345");
    }

    //======================Employee Tests
    @Test
    void getAllEmployees_ShouldreturnEmployeesList() throws Exception{
        //Arrange
        List<Employee> employees = Arrays.asList(testEmployee);
        when(inventoryService.getAllEmployees()).thenReturn(employees);


        //Act and Assert
        mockMvc.perform(get("/api/inventory/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(testEmployee.getId()))
                .andExpect(jsonPath("$[0].name").value(testEmployee.getName()))
                .andExpect(jsonPath("$[0].department").value(testEmployee.getDepartment()));

    }

    @Test
    void getEmployeeById_ShouldReturnEmployee() throws Exception{
        //Arrange
        when(inventoryService.getEmployeeById(101L)).thenReturn(Optional.of(testEmployee));

        //Act and Assert
        mockMvc.perform(get("/api/inventory/employees/{id}",101L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testEmployee.getId()))
                .andExpect(jsonPath("$.name").value(testEmployee.getName()))
                .andExpect(jsonPath("$.department").value(testEmployee.getDepartment()));
    }


    @Test
    void addEmployee_ShouldReturnCreatedEmployee() throws Exception{
        //Arrange
        Employee newEmployee = new Employee(null,"Sanji","Kitchen");
        Employee savedEmployee = new Employee(102L,"Sanji","Kitchen");
        when(inventoryService.addEmployee(any(Employee.class))).thenReturn(savedEmployee);

        //Act and Assert
        mockMvc.perform(post("/api/inventory/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newEmployee)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(102L))
                .andExpect(jsonPath("$.name").value("Sanji"))
                .andExpect(jsonPath("$.department").value("Kitchen"))
                .andExpect(jsonPath("$.assets").isArray())
                .andExpect(jsonPath("$.assets").isEmpty());

        verify(inventoryService,times(1)).addEmployee(any(Employee.class));

    }

    @Test
    void addEmployeeWithNullName_ShouldReturnBadRequest() throws Exception{
        //Arrange
        Employee invalidEmployee = new Employee(null,null,"Kitchen");

        when(inventoryService.addEmployee(any(Employee.class))).thenReturn(invalidEmployee);

        //Act and Assert
        mockMvc.perform(post("/api/inventory/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidEmployee)))
                .andExpect(status().isBadRequest());


        verify(inventoryService,never()).addEmployee(any(Employee.class));

    }

    @Test
    void addEmployeeWithNullDepartment_ShouldReturnBadRequest() throws Exception{
        //Arrange
        Employee invalidEmployee = new Employee(null,"Judens",null);

        when(inventoryService.addEmployee(any(Employee.class))).thenReturn(invalidEmployee);

        //Act and Assert
        mockMvc.perform(post("/api/inventory/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidEmployee)))
                .andExpect(status().isBadRequest());


        verify(inventoryService,never()).addEmployee(any(Employee.class));

    }

    @Test
    void addEmployeeWithExistingId_ShouldReturnIgnoreId() throws Exception{
        //Arrange
        Employee employeeWithId = new Employee(103L,"Judens","HR");
        Employee savedEmployee = new Employee(104L,"Judens","HR");
        when(inventoryService.addEmployee(any(Employee.class))).thenReturn(savedEmployee);

        //Act and Assert
        mockMvc.perform(post("/api/inventory/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeWithId)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(104L))
                .andExpect(jsonPath("$.name").value("Judens"))
                .andExpect(jsonPath("$.department").value("HR"));

        verify(inventoryService,times(1)).addEmployee(any(Employee.class));

    }

    //UPDATED
    @Test
    void updateEmployee_ShouldReturnUpdatedEmployee() throws Exception{
        //Arrange
        Long employeeId = 103L;
        Employee updateEmployee = new Employee(null,"Judens","HR");
        Employee savedEmployee = new Employee(employeeId,"Judens","HR");
        when(inventoryService.updateEmployee(eq(employeeId),any(Employee.class)))
                .thenReturn(savedEmployee);


        //Act and Assert
        mockMvc.perform(put("/api/inventory/employees/{id}",employeeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateEmployee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(employeeId))
                .andExpect(jsonPath("$.name").value("Judens"))
                .andExpect(jsonPath("$.department").value("HR"))
                .andExpect(jsonPath("$.assets").isArray())
                .andExpect(jsonPath("$.assets").isEmpty());

        verify(inventoryService,times(1)).updateEmployee(eq(employeeId),any(Employee.class));

    }

    @Test
    void updateEmployeeWithNullName_ShouldReturnBadRequest() throws Exception{
        //Arrange
        Long employeeId = 103L;
        Employee invalidEmployee = new Employee(null,null,"Kitchen");

        when(inventoryService.updateEmployee(eq(employeeId),any(Employee.class))).thenReturn(invalidEmployee);

        //Act and Assert
        mockMvc.perform(put("/api/inventory/employees/{id}", employeeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidEmployee)))
                .andExpect(status().isBadRequest());


        verify(inventoryService,never()).updateEmployee(any(Long.class),any(Employee.class));

    }

    @Test
    void updateEmployeeWithDepartment_ShouldReturnBadRequest() throws Exception{
        //Arrange
        Long employeeId = 103L;
        Employee invalidEmployee = new Employee(null,"Judens",null);

        when(inventoryService.updateEmployee(eq(employeeId),any(Employee.class))).thenReturn(invalidEmployee);

        //Act and Assert
        mockMvc.perform(put("/api/inventory/employees/{id}", employeeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidEmployee)))
                .andExpect(status().isBadRequest());


        verify(inventoryService,never()).updateEmployee(any(Long.class),any(Employee.class));

    }

    @Test
    void updateEmployeeWithInvalidId_ShouldReturnBadRequest() throws Exception{
        //Arrange
       String invalidEmployeeId = "12345ASD";


        //Act and Assert
        mockMvc.perform(put("/api/inventory/employees/{id}", invalidEmployeeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testEmployee)))
                .andExpect(status().isBadRequest());

        verify(inventoryService,never()).updateEmployee(anyLong(),any(Employee.class));

    }

    @Test
    void updateEmployeeWhenNotFound_ShouldReturnNotFound() throws Exception{
        //Arrange
        Long employeeId = 999L;
        Employee updateEmployee = new Employee(null,"Judens","Sales");

        when(inventoryService.updateEmployee(eq(employeeId),any(Employee.class)))
                .thenThrow(new IllegalArgumentException("Employee with id " + employeeId + " not found"));

        //Act and Assert
        mockMvc.perform(put("/api/inventory/employees/{id}", employeeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateEmployee)))
                .andExpect(status().isNotFound());


        verify(inventoryService,times(1)).updateEmployee(eq(employeeId),any(Employee.class));

    }

    //DELETE
    @Test
    void deleteEmployeeWhenNotFound_ShouldReturnNoContent() throws Exception{
        //Arrange
        Long employeeId = 102L;

        when(inventoryService.getEmployeeById(employeeId)).thenReturn(Optional.of(testEmployee));
        doNothing().when(inventoryService).deleteEmployeeById(employeeId);


        //Act and Assert
        mockMvc.perform(delete("/api/inventory/employees/{id}", employeeId))

                .andExpect(status().isNoContent());


        verify(inventoryService,times(1)).deleteEmployeeById(employeeId);

    }

    //==========================================ASSETS===================================================

}
