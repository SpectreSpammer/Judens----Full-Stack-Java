package com.onepieceofjava.JudensBandalSpringboot.service;

import com.onepieceofjava.JudensBandalSpringboot.model.Assets;
import com.onepieceofjava.JudensBandalSpringboot.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryService {

    private List<Employee> employeesList = new ArrayList<>();
    private List<Assets> assetsList = new ArrayList<>();

    private Long employeeId = 101L;
    private Long assetId = 201L;

    public InventoryService() {
        initializeEmployee();
    }

    private void initializeEmployee() {
        addEmployee(new Employee(null,"Judens Bandal","IT"));
        addEmployee(new Employee(null,"Nan","Devops"));
        addEmployee(new Employee(null,"Luffy","AWS"));
        addEmployee(new Employee(null,"Nami","Azure"));
        addEmployee(new Employee(null,"Sanji","Microsoft"));

        addAssset(new Assets(null,"Lenovo","Developers Laptop","LNV12345"));
        addAssset(new Assets(null,"MSI","Devops Laptop","MSI12345"));
        addAssset(new Assets(null,"Asus","AWS Laptop","Asus12345"));
        addAssset(new Assets(null,"Dell","Azure Laptop","DELLV12345"));
        addAssset(new Assets(null,"HP","Microsoft Laptop","HP12345"));

        assignAsset(101L,201L); // Judens -> Lenovo
        assignAsset(102L,202L); // Judens -> Lenovo
        assignAsset(103L,203L); // Judens -> Lenovo
        assignAsset(104L,204L); // Judens -> Lenovo
        assignAsset(105L,205L); // Judens -> Lenovo

    }


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



    public List<Assets> getAllAssets(){
        return assetsList;
    }

    public Assets getAssetById(long assetId){
        return assetsList.stream().filter( e -> e.getId().equals(this.assetId)).findFirst().orElse(null);
    }


    public Assets addAssset(Assets assets) {
        assets.setId(assetId++);
        assetsList.add(assets);
        return assets;
    }

    public void deleteAssetById(Long assetId) {
        assetsList.removeIf(e -> e.getId().equals(assetId));
    }

    public Employee removeAssetFromEmployee(Long employeeId, Long assetId){
        Optional<Employee> employeeOptional = employeesList.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        Optional<Assets> assetsOptional = assetsList.stream().filter(e -> e.getId().equals(assetId)).findFirst();

        if(employeeOptional.isPresent() && assetsOptional.isPresent()){
            employeeOptional.get().removeAsset(assetsOptional.get());
            return employeeOptional.get();
        }
        return null;
    }

    public List<Assets> getAssetsByEmployeeId(Long employeeId) {
        return employeesList.stream()
                .filter(e -> e.getId().equals(employeeId))
                .findFirst()
                .map(Employee::getAssets)
                .orElse(null);
    }


}
