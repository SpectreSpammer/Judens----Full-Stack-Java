package com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_gen")
    @TableGenerator(
            name = "employee_seq",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "employee_id",
            initialValue = 101,
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String department;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Assets> assets;

    public Employee() {
        this.assets =new ArrayList<>();
    }

    public Employee(Long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.assets = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Assets> getAssets() {
        return assets;
    }

    public void setAssets(List<Assets> assets) {
        this.assets = assets;
    }

    public void addAsset(Assets asset){
       assets.add(asset);
       asset.setEmployee(this);
    }

    public void removeAsset(Assets asset){
        assets.remove(asset);
        asset.setEmployee(null);
    }
}
