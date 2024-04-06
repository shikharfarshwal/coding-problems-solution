package com.old.code.leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter array size");
        final int n = scanner.nextInt();
        final int[] array = new int[n];
        System.out.println("enter the elements");
        for (int e = 0; e <= n - 1; e++) {
            array[e] = scanner.nextInt();
        }
        System.out.println("enter the value to compare");
        int val = scanner.nextInt();
        System.out.println(removeElement(array, val));
        Arrays.stream(array).forEach(System.out::println);

    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
