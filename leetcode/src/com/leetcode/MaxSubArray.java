package com.leetcode;

import java.util.Scanner;

public class MaxSubArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter array size");
        final int n = scanner.nextInt();
        final int[] array = new int[n];
        System.out.println("enter the elements");
        for (int e = 0; e <= n - 1; e++) {
            array[e] = scanner.nextInt();
        }
        findSubArrays(array);
    }

    private static void printSubArrays(final int[] array, final int i, final int j) {
        for (int k = i; k <= j; k++) {
            System.out.print(array[k]);
        }
        System.out.println(" ");

    }

    private static void findSubArrays(final int[] array) {
        final int length = array.length;
        for (int i = 0; i <= length - 1; i++) {
            for (int j = i; j <= length - 1; j++) {
                printSubArrays(array, i, j);
            }
        }


    }

}
