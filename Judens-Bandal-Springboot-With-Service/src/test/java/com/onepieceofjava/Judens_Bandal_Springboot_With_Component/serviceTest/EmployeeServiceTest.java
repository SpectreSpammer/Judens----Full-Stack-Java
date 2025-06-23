package com.onepieceofjava.Judens_Bandal_Springboot_With_Component.serviceTest;


import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Employee;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.repository.EmployeeRepository;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {


    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private InventoryService employeeService;

    private Employee testEmployee;

    private Employee updatedEmployee;

    @BeforeEach
    void setUp(){
        testEmployee = new Employee(101L, "Judens", "IT");
        updatedEmployee = new Employee(101L, "Judens Bandal - Updated" ,"Information Technology");
    }


    //GET ALL EMPLOYEES
    @Test
    void getAllEmployees_shouldReturnAllEmployees(){

        //Arrange
        List<Employee> expectedListOfEmployees = Arrays.asList(
                testEmployee,
                new Employee(102L,"Nan","Security")
        );
        when(employeeRepository.findAll()).thenReturn(expectedListOfEmployees);

        //Act
        List<Employee> actualEmployee = employeeService.getAllEmployees();

        //Assert
        assertEquals(expectedListOfEmployees.size(),actualEmployee.size());
        verify(employeeRepository).findAll();

    }

    //GET BY ID
    @Test
    void getEmployeeById_ShouldReturnEmployeeById_WhenEmployeeIsExist(){

        //Arrange
        when(employeeRepository.findById(5L)).thenReturn(Optional.of(testEmployee));


        //Act
        Optional<Employee> result = employeeService.getEmployeeById(5L);

        //assert
        assertTrue(result.isPresent());
        assertEquals(testEmployee.getName(),result.get().getName());
    }

    //ADD EMPLOYEE
    @Test
    void addEmployee_ShouldReturnSavedEmployee(){

        //Arrange
        when(employeeRepository.save(testEmployee)).thenReturn(testEmployee);


        //Act
        Employee savedEmployee = employeeService.addEmployee(testEmployee);

        //assert
        assertNotNull(savedEmployee);
        assertEquals(testEmployee.getName(),savedEmployee.getName());
        verify(employeeRepository).save(testEmployee);
    }

    //UPDATE EMPLOYEE
    @Test
    void updateEmployee_ShouldReturnUpdatedEmployee_WhenEmployeeExists(){

        //Arrange
        when(employeeRepository.existsById(1L)).thenReturn(true);

        when(employeeRepository.save(updatedEmployee)).thenReturn(updatedEmployee);


        //Act
        Employee result = employeeService.updateEmployee(1L,updatedEmployee);

        //assert
        assertNotNull(result);
        assertEquals(updatedEmployee.getName(),result.getName());
        verify(employeeRepository).existsById(1L);
        verify(employeeRepository).save(updatedEmployee);
    }

    @Test
    void updateEmployee_ShouldReturnUpdatedEmployee_WhenEmployeenNotExists(){

        //Arrange
        when(employeeRepository.existsById(1L)).thenReturn(false);



        //Act
        Employee result = employeeService.updateEmployee(1L,updatedEmployee);

        //assert
        assertNull(result);
        verify(employeeRepository).existsById(1L);
        verify(employeeRepository,never()).save(updatedEmployee);
    }

    //DELETE EMPLOYEE BY ID
    @Test
    void deleteEmployee_ShouldDeleteTheWholeEmployeee_WhenEmployeeExists(){

        //Arrange
       Long employeeId = 1L;

        //Act
       employeeService.deleteEmployeeById(employeeId);

        //assert
        verify(employeeRepository).deleteById(employeeId);
    }
}
