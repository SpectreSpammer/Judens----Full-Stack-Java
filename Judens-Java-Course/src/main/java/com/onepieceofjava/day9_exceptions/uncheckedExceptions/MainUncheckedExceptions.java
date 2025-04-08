package com.onepieceofjava.day9_exceptions.uncheckedExceptions;

public class MainUncheckedExceptions {
    public static void main(String[] args) {


        try{
            String name = null;
            System.out.println(name.length());
        }catch (NullPointerException e){
            System.out.println("Caught the error: " + e.getMessage());
        }

        try{
            int[] arr = new int[5];
            System.out.println(arr[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Caught the error: " + e.getMessage());
        }


//



    }
}
