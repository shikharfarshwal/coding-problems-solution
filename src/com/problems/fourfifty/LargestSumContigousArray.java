package com.problems.fourfifty;

import java.util.Scanner;

/*
To find the largest sum of a contiguous subarray, we can use Kadane's Algorithm.
This algorithm efficiently solves the problem in O(n) time complexity and is simple to implement.
The idea is to iterate through the array, keeping track of the maximum sum of the subarray that ends at the current position and the overall maximum sum found so far.

int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
 */
public class LargestSumContigousArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter array size");
        final int n = scanner.nextInt();
        final int[] array = new int[n];
        System.out.println("enter the elements");
        for (int e = 0; e <= n - 1; e++) {
            array[e] = scanner.nextInt();
        }
        System.out.println(findMaxSumSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
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
