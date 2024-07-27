package com.problems.striver;

import java.util.HashMap;
import java.util.Map;

/*
   https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
 */
// o(n)
public class LongestSubStringWithoutRepeatingCharacter {


    public static void main(String[] args) {
//        System.out.println(longestSubStringWithoutRepeatingCharacter("cadbzabcd"));
        System.out.println(longestSubStringWithoutRepeatingCharacter("abcabcbb"));
    }

    public static int longestSubStringWithoutRepeatingCharacter(String str) {
        int l = 0, r = 0;
        int max_len = 0;
        char[] arr = str.toCharArray();
        Map<Character, Integer> hashing = new HashMap<>();
        int len = 0;
        while (r < arr.length) {
            if (hashing.containsKey(arr[r]) && hashing.get(arr[r]) >= l) { //hashing.get(arr[r]) > l coz ek element jo pehle mil chuka he usko left pointer ke bd he substring mein count karna cahiye
                l = hashing.get(arr[r]) + 1;
            }
            hashing.put(arr[r], r);
            String substring = str.substring(l, r + 1);
            System.out.println(substring);
            len = r - l + 1;
            max_len = Math.max(len, max_len);
            System.out.println("max_len is: " + max_len);
            r++;
        }
        return max_len;
    }

}
