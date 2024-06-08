package com.problems.fourfifty;

import java.util.HashMap;

public class maxSubArraySumNotGreaterThanK {


    public static void main(String[] args) {
        int[] arr = {5, 4, -1, 7, 8};
        int k = 3;  // Example value for k
//        System.out.println(subarraySum(arr, k));
        System.out.println(maxSubArraySum(arr, k));
    }


    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    // int[] arr = {5, 4, -1, 7, 8};
    public static int maxSubArraySum(int[] arr, int k) {
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


    public static int maxSubArraySumNotGreaterThanK(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            // Shrink the window if the current sum exceeds k
            while (currentSum > k && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // Update the maximum sum if current sum is valid and greater than maxSum
            if (currentSum <= k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        // Handle the case where no subarray sum is less than or equal to k
        return (maxSum == Integer.MIN_VALUE) ? 0 : maxSum;
    }
}
