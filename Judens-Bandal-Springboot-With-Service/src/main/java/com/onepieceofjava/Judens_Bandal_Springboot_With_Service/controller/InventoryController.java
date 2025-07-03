package com.onepieceofjava.Judens_Bandal_Springboot_With_Service.controller;



import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Assets;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Employee;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;



    // ================== EMPLOYEES =====================

    //GET ALL
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return inventoryService.getAllEmployees();
    }

    //GET by Id
    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long employeeId){
        return inventoryService.getEmployeeById(employeeId);
    }

    // ADD
    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody     Employee addEmployees){
        try{
            if(addEmployees.getName() == null || addEmployees.getName().trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Employee name cannot be null or empty");
            }

            if(addEmployees.getDepartment() == null || addEmployees.getDepartment().trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Employee department cannot be null or empty");
            }
            Employee savedEmployee = inventoryService.addEmployee(addEmployees);
            return ResponseEntity.created(URI.create("/api/inventory/employees/" + savedEmployee.getId()))
                    .body(savedEmployee);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // Update
    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee){
        try{
            if(updatedEmployee.getName() == null || updatedEmployee.getName().trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Employee name cannot be null or empty");
            }

            if(updatedEmployee.getDepartment() == null || updatedEmployee.getDepartment().trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Employee department cannot be null or empty");
            }
            Employee update = inventoryService.updateEmployee(employeeId,updatedEmployee);
            return ResponseEntity.ok(update);

        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // Delete
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long employeeId){
        inventoryService.deleteEmployeeById(employeeId);
        return  ResponseEntity.noContent().build();
    }

    // ===================== ASSETS ======================

    // GET
    @GetMapping("/assets")
    public List<Assets> getAllAssets(){
        return inventoryService.getAllAssets();
    }


    @GetMapping("/assets/{assetId}")
    public Optional<Assets> getAssetById(@PathVariable Long assetId){
        return inventoryService.getAssetById(assetId);
    }



    //ADD
    @PostMapping("/assets")
    public ResponseEntity<Assets> addAssets(@RequestBody  Assets assets){
        Assets savedAssets = inventoryService.addAssset(assets);
        return ResponseEntity.created(URI.create("/api/inventory/assets" + savedAssets.getId()))
                .body(savedAssets);
    }

    //UPDATE
    @PutMapping("/assets/{assetId}")
    public ResponseEntity<?> updateAsset(@PathVariable Long assetId, @RequestBody Assets updatedAsset){
        try{



            //validate get name
            if(updatedAsset.getName() == null || updatedAsset.getName().trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Asset name cannot be null or empty");
            }

            //validate get type
            if(updatedAsset.getType() == null || updatedAsset.getType().trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Asset Type cannot be null or empty");
            }

            //validate get serial
            if(updatedAsset.getSerialNumber() == null || updatedAsset.getSerialNumber().trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Asset serial number cannot be null or empty");
            }

            Assets updated = inventoryService.updateAsset(assetId,updatedAsset);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                           .body(e.getMessage());
        }

    }



    //DELETE
    @DeleteMapping("/assets/{assetId}")
    public ResponseEntity<Void> deleteAssetById(@PathVariable Long assetId){
        inventoryService.deleteAssetById(assetId);
        return ResponseEntity.noContent().build();
    }

    // ===================== ASSIGNING ASSETS ======================
    //Assignning assets to specific employee
    @PostMapping("/employees/{employeeId}/assets/{assetId}")
    public ResponseEntity<?>assignAssetToTheSpecificEmployee(@PathVariable Long employeeId, @PathVariable Long assetId ){


        Optional<Employee> employeeOptional = inventoryService.getEmployeeById(employeeId);
        Optional<Assets> assetsOptional = inventoryService.getAssetById(assetId);

        if(employeeOptional.isPresent() && assetsOptional.isPresent()){
            Employee employee = employeeOptional.get();
            Assets assets = assetsOptional.get();

            //Set relationship
            assets.setEmployee(employee);
            employee.addAsset(assets);

            //save and update asset
            inventoryService.addAssset(assets);

            //save and update employee
            Employee updatedEmployee = inventoryService.addEmployee(employee);

            return ResponseEntity.created(URI.create("/api/inventory/employees/" + employeeId + "/assets/" + assetId))
                    .body(updatedEmployee);
        }

        return ResponseEntity.notFound().build();
    }

    //Delete Asset from specific employee
    @DeleteMapping("/employees/{employeeId}/assets/{assetId}")
    public ResponseEntity<?> deleteAssetFromSpecificEmployee(@PathVariable Long employeeId, @PathVariable Long assetId ){


        Optional<Employee> employeeOptional = inventoryService.getEmployeeById(employeeId);
        Optional<Assets> assetsOptional = inventoryService.getAssetById(assetId);

        if(employeeOptional.isPresent() && assetsOptional.isPresent()){

            Employee employee = employeeOptional.get();
            Assets assets = assetsOptional.get();

            //Set relationship
            assets.setEmployee(employee);
            employee.removeAsset(assets);

            //save and update asset
            inventoryService.deleteAssetById(assetId);


            return ResponseEntity.noContent ().build();
        }

        return ResponseEntity.notFound().build();
    }

    //Get asset from Specific employee
    @GetMapping("/employees/{employeeId}/assets")
    public List<Assets> getAssetsFromSpecificEmployee(@PathVariable Long employeeId){
        Optional<Employee> employeeOptional = inventoryService.getEmployeeById(employeeId);
        return employeeOptional.map(Employee::getAssets).orElse(null);
    }
}
