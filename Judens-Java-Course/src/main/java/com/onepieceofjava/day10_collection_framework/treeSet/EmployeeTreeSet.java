package com.onepieceofjava.day10_collection_framework.treeSet;

import java.util.Objects;

public class EmployeeTreeSet implements Comparable<EmployeeTreeSet>{

    private int  id;
    private String name;
    private String department;

    public EmployeeTreeSet(int id, String name, String department) {
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
        return "EmployeeArrayList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }


    @Override
    public int compareTo(EmployeeTreeSet o) {
        return Integer.compare(this.id,o.id);
    }
}
