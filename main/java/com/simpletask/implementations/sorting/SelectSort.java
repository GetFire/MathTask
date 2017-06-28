package com.simpletask.implementations.sorting;

import java.util.Arrays;

public class SelectSort {

    public static final int DESC = 0;
    public static final int ASC = 1;

    // Allows you to sort array in different ways

    public static int[] sort(int[] source, int choice) {
        if (choice == ASC) {
            return sortAsc(source);
        } else {
            return sortDesc(source);
        }
    }

    private static int[] sortDesc(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int max = source[i];
            int maxIndex = i;
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] > max) {
                    max = source[j];
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                int tmp = source[i];
                source[i] = source[maxIndex];
                source[maxIndex] = tmp;
            }
        }
        return source;
    }

    private static int[] sortAsc(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int min = source[i];
            int minIndex = i;
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] < min) {
                    min = source[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = source[i];
                source[i] = source[minIndex];
                source[minIndex] = tmp;
            }
        }
        return source;
    }

    // default approach
    public static int[] sort(int[] source) {
        return sortAsc(source);
    }


    public static int[] getArray() {
        int size = (int) (Math.random() * (30 - 1)) + 1;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(SelectSort.sort(array)));
        System.out.println(Arrays.toString(SelectSort.sort(array, DESC)));
    }
}
