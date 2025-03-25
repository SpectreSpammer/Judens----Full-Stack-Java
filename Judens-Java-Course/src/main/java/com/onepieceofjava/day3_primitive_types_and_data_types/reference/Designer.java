package com.onepieceofjava.day3_primitive_types_and_data_types.reference;

public class Designer implements Employee{
    @Override
    public void work() {
        System.out.println("Designer is designing the UI.");
    }

    @Override
    public void lunch() {
        System.out.println("Designer is having his short walk.");
    }

    @Override
    public void meeting() {
        System.out.println("Designer is presenting the design in the meeting.");
    }
}
