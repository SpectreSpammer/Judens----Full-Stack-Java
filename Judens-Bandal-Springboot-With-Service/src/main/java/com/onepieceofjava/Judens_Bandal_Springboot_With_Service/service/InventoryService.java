package com.onepieceofjava.Judens_Bandal_Springboot_With_Service.service;



import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Assets;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Employee;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.repository.AssetRepository;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {


    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;





    // =============== GET Employee =============
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(long employeeId){
        return employeeRepository.findById(employeeId);
    }


    // ================== ADD Employee ==============
    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee( Long employeeId, Employee updateEmployee){

        if(employeeRepository.existsById(employeeId)){
            updateEmployee.setId(employeeId);
            return employeeRepository.save(updateEmployee);
        }
        return null;
    }

    public void deleteEmployeeById(Long employeeId){
      employeeRepository.deleteById(employeeId);

    }



    // ================ ASSETS =================



    //GET ALL ASSETS
    public List<Assets> getAllAssets(){
        return assetRepository.findAll();
    }

    //GET ASSETS BY ID
    public Optional<Assets> getAssetById(long assetId){
        return assetRepository.findById(assetId);
    }


    //ADD ASSETS
    public Assets addAssset(Assets assets) {

        return assetRepository.save(assets);
    }

    //UPDATE ASSET
    public Assets updateAsset(Long assetId, Assets updatedAsset) {
        if(assetRepository.existsById(assetId)){
            updatedAsset.setId(assetId);
            return assetRepository.save(updatedAsset);
        }
        return null;
    }

    //DELETE ASSET BY ID
    public void deleteAssetById(Long assetId) {
       assetRepository.deleteById(assetId);
    }



    //UPDATE ASSET





}
