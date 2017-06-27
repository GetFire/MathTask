package com.simpletask.implementations.algorithms;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String args[]) {
        int c;
        int first;
        int last;
        int middle;
        int size;
        int search;
        int array[];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements");
        size = in.nextInt();
        array = new int[size];

        System.out.println("Enter " + size + " integers");


        for (c = 0; c < size; c++) {
            array[c] = in.nextInt();
        }

        System.out.println("Enter value to find");
        search = in.nextInt();

        first = 0;
        last = array.length - 1;
        middle = (first + last) / 2;
        int count = 0;

        while (first <= last) {
            ++count;
            if (array[middle] < search)
                first = middle + 1;
            else if (array[middle] == search) {
                System.out.println(search + " found at location " + (middle + 1) + ".");
                break;
            } else
                last = middle - 1;

            middle = (first + last) / 2;
        }
        if (first > last)
            System.out.println(search + " is not present in the list.\n");
        System.out.println(count);
    }
}

