package com.onepieceofjava.day9_exceptions.checkedExceptions;

import java.io.FileNotFoundException;

public class MainCheckedException {
    public static void main(String[] args){

        CheckExceptions.connectToDatabase();
        CheckExceptions.readFile("C:\\Users\\Mugiwara\\OneDrive\\Videos\\Judens Bandal\\day1");
    }
}
