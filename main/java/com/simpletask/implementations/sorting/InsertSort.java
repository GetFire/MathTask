package com.simpletask.implementations.sorting;

import java.io.PrintWriter;
import java.util.Scanner;

// TODO this is weak class, I`ve to fix it
public class InsertSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        System.out.println("Please enter array size");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Now you have to fill arrray with size: " + size);
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 1; i < size; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[i] > temp) {
                array[j + 1] = array[i];
                j--;
            }
            array[j + 1] = temp;
        }
        for (int i = 0; i < size; i++) {
            writer.print(array[i] + " ");
        }
        scanner.close();
        writer.close();
    }

}
