package com.onepieceofjava.JudensBandalSpringboot.controller;


import com.onepieceofjava.JudensBandalSpringboot.model.Employee;
import com.onepieceofjava.JudensBandalSpringboot.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController() {
        this.inventoryService = new InventoryService();
    }

    // ================== EMPLOYEES =====================

    //GET ALL
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return inventoryService.getAllEmployees();
    }

    //GET by Id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId){
        return inventoryService.getEmployeeById(employeeId);
    }

    // ADD
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody     Employee employees){
        return inventoryService.addEmployee(employees);
    }

    // Update
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updateEmployee){
        return inventoryService.updateEmployee(employeeId,updateEmployee);
    }

    // Detele
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        inventoryService.deleteEmployeeById(employeeId);
    }

    // ===================== ASSETS ======================
}
