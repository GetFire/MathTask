package com.simpletask.implementations.algorithms;

import java.util.Arrays;

// find sum of all members of array
public class RecursionAlgorithm {

    public static int findSum(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else {
            return array[0] + findSum(Arrays.copyOfRange(array, 1, array.length));
        }
    }

    public static void main(String[] args) {
        int[] array = new int[17500];
        Arrays.fill(array,5);
        System.out.println(findSum(array));
    }

}
