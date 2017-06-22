package com.simpletask.eckel.tasks.chapter4;

import java.util.Arrays;

/**
 * This class is a solution for Task 4
 * <p>
 * Print only prime numbers
 */
public class PrimeFinder {

    boolean[] primes;

    /**
     * This method implements Sieve of Eratosthenes algorithm
     * @param size set the boundaries of sieve
     */
    private void createPrimeSieve(int size) {
        primes = new boolean[size];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = primes[0];
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

//    /**
//     * look for prime numbers
//     *
//     * @param size - set the boundaries (will find in array 0->  size)
//     */
//
//    void findPrime(int size) {
//        long milisec = System.currentTimeMillis();
//        int count = 0;
//        for (int i = 0; i < size; i++) {
//            if (i % 2 == 0) {
//                continue;
//            }
//            for (int j = 2; j <= i; j ++) {
//                if (i % j == 0) {
//                    System.out.print(i + ", ");
//                    count++;
//                    break;
//                }
//            }
//        }
//        milisec = System.currentTimeMillis() - milisec;
//        System.out.println("Perfomance: " + milisec);
//        System.out.println("Count is: " + count);
//    }

    void findPrimeViaSieve(int size) {
        createPrimeSieve(size);
        int count = 0;
        long milisec = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            if (primes[i]) {
                System.out.print(i + ", ");
                count++;
            }
        }
        System.out.println("\nPerformance: " + (System.currentTimeMillis() - milisec));
        System.out.println("Count is: " + count);

    }

    public static void main(String[] args) {
        PrimeFinder finder = new PrimeFinder();
        finder.findPrimeViaSieve(100);
    }
}
