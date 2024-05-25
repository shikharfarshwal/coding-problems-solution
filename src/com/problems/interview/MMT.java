package com.problems.interview;

import java.util.ArrayList;
import java.util.List;

public class MMT {


  /*

  https://leetcode.com/problems/coin-change/
Given an integer array of coins[ ] of size N representing different types of denominations and an integer sum,
the task is to find the number of ways to make sum by using different denominations.
Note: Assume that you have an infinite supply of each type of coin.

Examples
Input: sum = 4, coins[] = {1,2,3},
 Output: 4
Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.


2.) sum = 21 , coins[] {5,1}

5 + 5 + 5 = sum
:- second part
   How many min no of coin require to make this sum.
   */
  public static void main(String[] args) {
    int[] coins = new int[]{1, 2, 3};
    final int maxCoins = findMaxCoins(coins, 4);
    System.out.println(maxCoins);
  }

  public static int findMaxCoins(int[] coins, int sum) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= coins.length - 1; i++) {
      final int count = countCoins(coins[i], 0, sum) / coins[i];
      list.add(count);
    }
    return list.size();
  }

  public static int countCoins(int coinValue, int coinCount, int sum) {
    if (sum == coinCount || coinCount > sum) {
      return coinCount;
    } else {
      coinCount = coinCount + coinValue;
      return countCoins(coinValue, coinCount, sum);
    }
  }
}
