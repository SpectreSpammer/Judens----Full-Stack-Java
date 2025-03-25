package com.onepieceofjava.day4_operators.ternary;

public class MainTernary {

    public static void main(String[] args) {

        //condition ? expression1 : expression

        int age = 29;
        System.out.println(age < 65 ? "not yet retired" : "retired");

        /*
        if(age < 65 ){
            System.out.println("not yet retired");
        }else {
            System.out.println("retired");
        }
        */
        boolean isReceiveTheBonus = false;
        String receivedBonus = isReceiveTheBonus ? "received bonus" : "not yet received the bonus";

        System.out.println("Judens has: "  + receivedBonus);
    }
}
