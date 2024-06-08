package com.problems.interview;

/*
Q1 Largest sum of a contigous sub array (kadane algorithm)
Q2 Same question but the sum shouldn't be greater then k
Had 3 test cases one test case was unable to solve {5,4,-1,7,8} , k=3
 */
public class Grab {

    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(maxSubArraySumWithK(new int[]{5, 4, -1, 7, 8}, 3));
        System.out.println(maxSubArraySumWithKOptimized(new int[]{5, 4, -1, 7, 8}, 3));
    }


    //kadane algorithm
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

    /*
    Brute force
     */
    public static int maxSubArraySumWithK(int[] arr, int k) {
        int max_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int max_current = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                max_current = Math.max(max_sum, max_current + arr[j]);

                if (max_current > max_sum && max_current <= k) {
                    max_sum = max_current;
                }
            }
        }
        return max_sum;
    }


    //      Had 3 test cases one test case was unable to solve {5,4,-1,7,8} , k=3
    private static int maxSubArraySumWithKOptimized(final int[] array, int k) {
        int max_global = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            int max_current = array[i];
            int j = i + 1;
            if (j < array.length) {
                max_current = Math.max(max_global, array[j] + max_current);
                if (max_current > max_global && max_current <= k) {
                    max_global = max_current;
                }
            }
        }
        return max_global;
    }
}
