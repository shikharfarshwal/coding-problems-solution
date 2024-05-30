package com.problems.fourfifty;

import java.util.Arrays;

//Question 1 With soultion
/*
Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.
 Input:
N = 3, sum = 4
coins = {1,2,3}
Output: 4
Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
*/
public class CoinChangeProblem {
    public static void main(String[] args) {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
        int n = 18;
        System.out.println(coinChangeProblem.minCoins(n, new int[]{1, 5, 7}));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println(coinChangeProblem.minCoinsDP(n, new int[]{1, 5, 7}, dp));
        for (int i : dp) {
            System.out.print(i + " ");
        }

        System.out.println(coinChangeProblem.countWays(new int[]{1, 2, 3} , 3 , 4));
    }

    private int minCoins(int sum, int[] a) {
        if (sum == 0) return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= a.length - 1; i++) {

            if (sum - a[i] >= 0) {
                int subAns = minCoins(sum - a[i], a);
                if (subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        return ans;
    }


    private int minCoinsDP(int sum, int[] a, int[] dp) {

        if (sum == 0) return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= a.length - 1; i++) {
            if (sum - a[i] >= 0) {
                int subAns = 0;
                if (dp[sum - a[i]] != -1) {
                    subAns = dp[sum - a[i]];
                } else {
                    subAns = minCoinsDP(sum - a[i], a, dp);
                }
                if (subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        dp[sum] = ans;
        return ans;
    }


//Question 2 need to solve
 /*
Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the sum with minimum no of coins by using different combinations from coins[ ].
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.
Input:
N = 3, sum = 4
coins = {1,2,3}
Output: 4
Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
*/

    private int countWays(int[] coins, int coinIndex, int remainingSum) {
        // Base cases:
        // If remaining sum is 0, we found a valid combination
        if (remainingSum == 0) {
            return 1;
        }
        // If remaining sum is negative or there are no coins left
        if (remainingSum < 0 || coinIndex <= 0) {
            return 0;
        }

        // Include the coin at coinIndex in the sum and recursively count the ways
        int includeCoin = countWays(coins, coinIndex, remainingSum - coins[coinIndex - 1]);

        // Exclude the coin at coinIndex from the sum and recursively count the ways
        int excludeCoin = countWays(coins, coinIndex - 1, remainingSum);

        // Return the total number of ways by summing the ways including and excluding the coin
        return includeCoin + excludeCoin;
    }


}
