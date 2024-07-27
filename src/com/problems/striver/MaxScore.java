package com.problems.striver;

/*
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaxScore {

    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

    public int maxScore(int[] cardPoints, int k) {
        int max_sum = 0, lsum = 0, rsum = 0;
        int r = cardPoints.length - 1;

        for (int i = 0; i < k; i++) {
            lsum = lsum + cardPoints[i];
        }
        max_sum = lsum;
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[r];
            r--;
            max_sum = Math.max(max_sum, lsum + rsum);
        }
        return max_sum;
    }
}
