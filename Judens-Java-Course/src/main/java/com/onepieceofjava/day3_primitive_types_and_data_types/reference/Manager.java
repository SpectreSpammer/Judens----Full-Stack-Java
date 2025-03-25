package com.onepieceofjava.day3_primitive_types_and_data_types.reference;

public class Manager implements Employee{
    @Override
    public void work() {
        System.out.println("Manager is leading the project.");
    }

    @Override
    public void lunch() {
        System.out.println("Manager is having his lunch.");
    }

    @Override
    public void meeting() {
        System.out.println("Manager is facilitating the meeting.");
    }
}
