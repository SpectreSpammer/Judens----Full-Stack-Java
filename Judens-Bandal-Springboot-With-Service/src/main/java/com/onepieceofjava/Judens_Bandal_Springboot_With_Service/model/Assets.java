package com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model;


import jakarta.persistence.*;

@Entity
@Table(name = "assets")
public class Assets {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "asset_Seq")
    @SequenceGenerator(
            name = "asset_seq",
            sequenceName = "asset_sequence",
            initialValue = 201,
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String type;
    private String serialNumber;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Assets() {
    }

    public Assets(Long id, String name, String type, String serialNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
