package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        final int[] values = new int[4];
        values[0] = 3;
        values[1] = 2;
        values[2] = 4;
        //values[3] = ;
        final int[] ints = twoSum.twoSumBest(values, 6);
        Arrays.stream(ints).forEach(System.out::println);
    }

   /* public int[] twoSum(int[] nums, int target) {
        final int[] values = new int[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            while (j <= nums.length - 1) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    values[0] = i;
                    values[1] = j;
                    return values;
                }
                j++;
            }
        }
        return values;
    }*/

    public int[] twoSumBest(int[] nums, int target) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            integerMap.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (integerMap.containsKey(complement) && integerMap.get(complement) != j) {
                return new int[]{j, integerMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


   /* public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/
}
