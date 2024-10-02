package com.problems.striver.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsIntoBasket {

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



   /* public static void main(String[] args) {
        List<Integer> price = Arrays.as
        List(2, 4);
        double discount = Math.pow(2, 2);
        double floor = Math.floor(price.get(0) / discount);
        price.set(0, (int) floor);
        System.out.println();
        int min_sum = 0;
        for (Integer item_price : price) {
            min_sum = min_sum + item_price;
        }

   /* public static long findMinimumPrice(List<Integer> prices, int m) {
        Collections.sort(prices, Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            int discount = (int) Math.floor(prices.get(0) / 2.0);
            prices.set(0, discount);
            Collections.sort(prices, Collections.reverseOrder());
        }
        return prices.stream().mapToInt(Integer::intValue).sum();
    }*/

   /* public static long findMinimumPrice1(List<Integer> prices, int m) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue <>(Collections.reverseOrder());

        maxHeap.addAll(prices);
        while(m>0 && !maxHeap.isEmpty()){
            int highPrice = maxHeap.poll();
            if(highPrice == 0)
            {
                break;
            }
            int newCalPrice = (int) Math.floor(highPrice /2.0);
            maxHeap.offer(newCalPrice);
            m--;
        }

        int totalAmount =0;
        while(!maxHeap.isEmpty()){
            totalAmount += maxHeap.poll();
        }
        return totalAmount;
    }*/
