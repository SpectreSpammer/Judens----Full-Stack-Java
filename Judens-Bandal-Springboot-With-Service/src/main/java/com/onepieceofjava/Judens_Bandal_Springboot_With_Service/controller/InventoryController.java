package com.onepieceofjava.Judens_Bandal_Springboot_With_Service.controller;



import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Assets;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Employee;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    //constructor based dependency injecton
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
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

    // Delete
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        inventoryService.deleteEmployeeById(employeeId);
    }

    // ===================== ASSETS ======================

    // GET
    @GetMapping("/assets")
    public List<Assets> getAllAssets(){
        return inventoryService.getAllAssets();
    }


    @GetMapping("/assets/{employeeId}")
    public Assets getAssetById(@PathVariable Long assetId){
        return inventoryService.getAssetById(assetId);
    }

    @GetMapping("/employees/{employeeId}/assets")
    public List<Assets> getEmployeeAssetByEmployeeId(@PathVariable Long employeeId){
        return inventoryService.getAssetsByEmployeeId(employeeId);
    }

    //ADD

    @PostMapping("/assets")
    public Assets addAssets(@RequestBody  Assets assets){
        return inventoryService.addAssset(assets);
    }


    @PostMapping("/employees/{employeeId}/assets/{assetId}")
    public Employee addAssetToSpecificEmployee(@PathVariable Long employeeId,@PathVariable Long assetId){
        return inventoryService.assignAsset(employeeId,assetId);
    }


    //DELETE
    @DeleteMapping("/employees/{employeeId}/assets/{assetId}")
    public void removeAssetFromSpecificEmployee(@PathVariable Long employeeId, @PathVariable Long assetId){
        inventoryService.removeAssetFromEmployee(employeeId,assetId);
    }

    @DeleteMapping("/assets/{assetId}")
    public void deleteAssetById(@PathVariable Long assetId){
        inventoryService.deleteAssetById(assetId);
    }


}
