package com.old.code.leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInsertPosition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter array size");
        final int n = scanner.nextInt();
        final int[] array = new int[n];
        System.out.println("enter the elements");
        for (int e = 0; e <= n - 1; e++) {
            array[e] = scanner.nextInt();
        }
        System.out.println("enter the target value to compare");
        int val = scanner.nextInt();
        System.out.println(searchInsert(array, val));
        Arrays.stream(array).forEach(System.out::println);
    }

    private static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return length;
    }
}
