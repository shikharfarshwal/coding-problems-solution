package com.problems.striver;

import java.util.HashMap;
import java.util.Map;

//LongestSubstring With Atmost K Distinct char


public class LongestSubstringWithAtmostKDistinctchar {

    public static void main(String[] args) {
        System.out.println(LongestSubstringWithAtmostKDistinctchar(new char[]{'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd'}, 2));
    }

    static int LongestSubstringWithAtmostKDistinctchar(char[] arr, int k) {
        int l = 0, r = 0;
        int max_len = 0;
        Map<Character, Integer> space = new HashMap<>();

        while (r < arr.length) {
            if (space.containsKey(arr[r])) {
                Integer count = space.get(arr[r]);
                space.put(arr[r], ++count);
            } else {
                space.put(arr[r], 1);
            }

            if (space.size() <= k) {
                max_len = Math.max(max_len, r - l + 1);
            } else {
                Integer count = space.get(arr[l]);
                if (count == 0) {
                    space.remove(arr[l]);
                }
                space.put(arr[l], --count);
                l++;
            }
            r++;
        }
        return max_len;
    }
}
