package com.simpletask.math.task;

public class RoundingOfANumber {
    public static void main(String[] args) {
        double a;
        a = 4.5; // тут вводим любое вещественное число

        // also we can use static method
        System.out.println("Another var to round number - using static method: " + Math.round(a));

        double n = a - (int) a;
        System.out.print(a + " округляем и получается - ");
        if (n >= 0.5) {
            a++;
        } else {
            a = (int) a;
        }
        System.out.print((int) a + "\n");


    }

}