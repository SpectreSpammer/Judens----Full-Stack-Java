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
}
