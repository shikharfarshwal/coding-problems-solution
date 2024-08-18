package com.problems.striver;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsIntoBasket {


    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}, 2));
    }

    //O(2N)
    public static int totalFruit2N(int[] fruits, int k) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> baskets = new HashMap<>();

        while (r < fruits.length) {
            if (baskets.get(fruits[r]) == null) {
                baskets.put(fruits[r], 1);
            } else {
                Integer count = baskets.get(fruits[r]);
                baskets.put(fruits[r], ++count);
            }

            if (baskets.size() > k) {
                while (baskets.size() > k) {
                    Integer count = baskets.get(fruits[l]);
                    baskets.put(fruits[l], --count);
                    if (count == 0) {
                        baskets.remove(fruits[l]);
                    }
                    l++;
                }
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }


    //O(N)
    public static int totalFruit(int[] fruits, int k) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> baskets = new HashMap<>();

        while (r < fruits.length) {
            if (baskets.get(fruits[r]) == null) {
                baskets.put(fruits[r], 1);
            } else {
                Integer count = baskets.get(fruits[r]);
                baskets.put(fruits[r], ++count);
            }

            if (baskets.size() > k) {
                Integer count = baskets.get(fruits[l]);
                baskets.put(fruits[l], --count);
                if (count == 0) {
                    baskets.remove(fruits[l]);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
