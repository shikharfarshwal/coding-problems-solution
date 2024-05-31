package com.problems.fourfifty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates.
 There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.


Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.
 */
public class ChocolateDistributionSolution {

    public static void main(String[] args) {
        ChocolateDistributionSolution cds = new ChocolateDistributionSolution();
        long minDiff = cds.findMinDiff(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12), 8, 5);
        System.out.println(minDiff);
    }

    public long findMinDiff(List<Integer> a, int n, int m) {

        if (m >= n) {
            return -1;
        }

        if (m == 0 || n == 0) {
            return -1;
        }
        if (a.isEmpty()) {
            return -1;
        }
        Collections.sort(a);
        int MIN_INT = Integer.MAX_VALUE;
        int i = 0;
        while (i < n && (i + m - 1) < n) {
            int min = a.get(i + m - 1) - a.get(i);
            if (min < MIN_INT) {
                MIN_INT = min;
            }
            i++;
        }
        return MIN_INT;
    }
}
