package com.example;

import java.util.Scanner;

/**
 * Maximum sum of a subarray in o(n)2
 * [-2,-5,6,-2,-3,1,5,-6]
 */
public class MaxSumSubArrayNSquareTimeComplexity {

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
        final int length = array.length;
        int maxSum = array[0];
        for (int i = 1; i <= length - 1; i++) {
            int sum = 0;
            for (int j = i; j <= length - 1; j++) {
                sum = sum + array[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
