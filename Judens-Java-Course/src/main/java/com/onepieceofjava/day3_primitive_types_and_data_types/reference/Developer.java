package com.onepieceofjava.day3_primitive_types_and_data_types.reference;

public class Developer implements Employee{
    @Override
    public void work() {
        System.out.println("Developer is writing some code.");
    }

    @Override
    public void lunch() {
        System.out.println("Developer is having his coffee break.");
    }

    @Override
    public void meeting() {
        System.out.println("Developer is attending the meeting.");
    }
}
