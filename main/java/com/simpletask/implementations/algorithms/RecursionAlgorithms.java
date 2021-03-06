package com.simpletask.implementations.algorithms;

import java.util.Arrays;

// find sum of all members of array
public class RecursionAlgorithms {

    /**
     * Much expensive that simple "for" loop. Besides that, it throw SO Exception, when array length is bigger than 17000
     */
    public static int findSumRec(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else {
            return array[0] + findSumRec(Arrays.copyOfRange(array, 1, array.length));
        }
    }

    /**
     * The cost of this approach is cheaper than recursion, and it can work with large arrays
     */
    public static int findSumFor(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }
        return res;
    }
    /**
     * This method allows you to find length for given arrays
     */
    public static int count(int[] array) {
        if (array.length == 1) {
            return 1;
        } else return 1 + count(Arrays.copyOfRange(array, 1, array.length));
    }

    public static void main(String[] args) {
        int[] array = new int[17500];
        Arrays.fill(array, 5);

        long timer = System.currentTimeMillis();
        System.out.println(findSumRec(array));
        System.out.println("performance with recursion is " + (System.currentTimeMillis() - timer) + "ms");

        timer = System.currentTimeMillis();
        System.out.println(findSumFor(array));
        System.out.println("performance with for is " + (System.currentTimeMillis() - timer) + "ms");

        timer = System.currentTimeMillis();
        System.out.println(count(array));
        System.out.println("performance count is " + (System.currentTimeMillis() - timer) + "ms");
    }

}
