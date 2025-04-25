package com.onepieceofjava.day10_collection_framework.hashSet;

import java.util.Objects;

public class EmployeeHashSet {

    private int  id;
    private String name;
    private String department;

    public EmployeeHashSet(int id, String name, String department) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeHashSet that = (EmployeeHashSet) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }
}
