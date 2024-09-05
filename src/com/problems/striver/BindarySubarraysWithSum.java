package com.problems.striver;
//https://leetcode.com/problems/binary-subarrays-with-sum/description/
public class BindarySubarraysWithSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        int count = countSubArraySum(nums, goal) - countSubArraySum(nums, goal - 1);
        // TC = O(2* 2N)
        System.out.println(count);
    }


    // fn(nums, goal) - fn(nums, goal-1) = count of subarray with sum == goal
    public static int countSubArraySum(int[] nums, int goal) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;

        if (goal < 0) return 0;
        while (r < nums.length) { // O(N)
            sum += nums[r];
            while (sum > goal) { //O(N)
                sum = sum - nums[l];
                l = l + 1;
            }
            count = count + (r - l + 1); // r - l + 1 [100110] gives you count of subarrays
            r = r + 1;
        }
        return count;
    }
}
