package com.simpletask.math.task;

import java.util.Scanner;

public class SummOfTwoComponentsOfDigit {
    public static void main(String[] args) {
        System.out.println("Введите двухзначное число ");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); //вводим здесь двухзначное число
        int b = a % 10;
        int c = (a / 10) % 10;
        int d = b + c;
        System.out.println("Вы задали число " + a + ", а сумма его составных будет " + d);

    }
}

