package com.onepieceofjava.Judens_Bandal_Springboot_With_Service.service;



import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Assets;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Employee;
import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {


    @Autowired
    private AssetRepository assetRepository







    // =============== GET Employee =============
    public List<Employee> getAllEmployees(){
        return employeesList;
    }

    public Employee getEmployeeById(long employeeId){
        return employeesList.stream().filter( e -> e.getId().equals(employeeId)).findFirst().orElse(null);
    }


    // ================== ADD Employee ==============
    public Employee addEmployee(Employee employee) {
        employee.setId(employeeId++);
        if(employee.getAssets() != null && !employee.getAssets().isEmpty()){
            for(Assets assets : employee.getAssets()){
                assets.setId(assetId++);
            }
        }
        employeesList.add(employee);
        return employee;
    }

    public Employee updateEmployee( Long employeeId, Employee updateEmployee){

        for(int i = 0; i< employeesList.size();i++){
            if(employeesList.get(i).getId().equals(employeeId)){
                updateEmployee.setId(employeeId);
                employeesList.set(i,updateEmployee);
                return updateEmployee;
            }
        }
        return null;
    }

    public void deleteEmployeeById(Long employeeId){
        employeesList.removeIf( e -> e.getId().equals(employeeId));

        /*
        if(employeeId.equals(employeeId)){
            employeesList.remove(employeeId);
        }else {
            throw null;
        }
        */


    }


    public Employee assignAsset(long employeeId, long assetId) {
        Optional<Employee> employeeOptional = employeesList.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        Optional<Assets> assetsOptional = assetsList.stream().filter(e -> e.getId().equals(assetId)).findFirst();

        if(employeeOptional.isPresent() && assetsOptional.isPresent()){
            employeeOptional.get().addAsset(assetsOptional.get());
            return employeeOptional.get();
        }
        return null;
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


    //DELETE ASSET BY ID
    public void deleteAssetById(Long assetId) {
       assetRepository.deleteById(assetId);
    }

    //UPDATE ASSET





}
