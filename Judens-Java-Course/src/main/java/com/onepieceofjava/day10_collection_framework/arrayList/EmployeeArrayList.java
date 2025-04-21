package com.onepieceofjava.day10_collection_framework.arrayList;

public class EmployeeArrayList {

    private int  id;
    private String name;
    private String department;

    public EmployeeArrayList(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeArrayList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
