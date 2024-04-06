package com.old.code.leetCode;

import java.util.Scanner;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter array size");
        final int n = scanner.nextInt();
        final int[] array = new int[n];
        System.out.println("enter the elements");
        for (int e = 0; e <= n - 1; e++) {
            array[e] = scanner.nextInt();
        }
        System.out.println(findMaxSumSubArray(array));
    }

    private static int findMaxSumSubArray(final int[] array) {
        int max_current = array[0], max_global = array[0];
        for (int i = 1; i <= array.length - 1; i++) {
            max_current = Math.max(array[i], array[i] + max_current);
            if (max_current > max_global) {
                max_global = max_current;
            }
        }
        return max_global;
    }


}
