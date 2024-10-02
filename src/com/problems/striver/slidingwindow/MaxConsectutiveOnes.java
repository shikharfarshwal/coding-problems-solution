package com.problems.striver.slidingwindow;

/*

 */
public class MaxConsectutiveOnes {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(lengthLongestConsecutiveOnes(arr, 2));
        System.out.println(lengthLongestConsecutiveOnesOptimized(arr, 2));
    }

    // O(N) --> r + O(N) --> l = O(2(N))
    public static int lengthLongestConsecutiveOnes(int[] arr, int k) {
        int maxLen = 0;
        int zero = 0;
        int l = 0;
        int r = 0;

        while (r < arr.length) {
            if (arr[r] == 0) {
                zero++;
            }

            while (zero > k) {
                if (arr[l] == 0) {
                    zero--;
                }
                l++;
            }

            if (zero <= k) {
                maxLen = Math.max(r - l + 1, maxLen);
            }
            r++;
        }
        return maxLen;
    }

    public static int lengthLongestConsecutiveOnesOptimized(int[] arr, int k) {
        int maxLen = 0;
        int zero = 0;
        int l = 0;
        int r = 0;

        while (r < arr.length) {
            if (arr[r] == 0) {
                zero++;
            }

            if (zero > k) {
                if (arr[l] == 0) {
                    zero--;
                }
                l++;
            }

            if (zero <= k) {
                maxLen = Math.max(r - l + 1, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}
