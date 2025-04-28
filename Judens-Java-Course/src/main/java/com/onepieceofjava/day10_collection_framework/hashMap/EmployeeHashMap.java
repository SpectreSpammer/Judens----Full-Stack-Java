package com.onepieceofjava.day10_collection_framework.hashMap;

public class EmployeeHashMap {

    private int  id;
    private String name;
    private String department;

    public EmployeeHashMap(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "EmployeeHashMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
