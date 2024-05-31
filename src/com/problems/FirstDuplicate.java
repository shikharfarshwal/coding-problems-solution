package com.problems;

import java.util.Scanner;

/**
 * 0,1,2,3,4,5
 * < N -length
 * [2,1,3,5,3,2] first duplicate element o(n)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * //index
 * [ 2,1,3,5,3,2]
 * [ 2,-1,3,5,3,2] j =0;
 * [-2,-1,3,5,3,2] j=1;
 * [-2,-1,-3,5,3,2] j=2;
 * [-2,-1,-3,5,-3,2] j=3;
 * [-2,-1,-3,5,-3,2] j=4;
 */
public class FirstDuplicate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        FirstDuplicate firstDuplicate = new FirstDuplicate();
        System.out.println(firstDuplicate.findDuplicate(a));
    }

    private int findDuplicate(final int[] array) {
        for (int j = 0; j < array.length; j++) {
                if (array[Math.abs(array[j]) - 1] < 0) { // i will return back to the number j as an index
                    // and see if its value is already negative and if it is then we found our first dupicate value
                    return Math.abs(array[j]);
                } else {
                    array[Math.abs(array[j]) - 1] = -array[Math.abs(array[j]) - 1];
                }
        }
        return -1;
    }

}
