package com.old.code.leetCode;

import java.util.*;

/**
 * Created by Shikhar on 17-03-2019.
 */
//not a good solution as it is O(N)3
public class LongestSubStringwithoutRepeChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        LongestSubStringwithoutRepeChar longestSubStringwithoutRepeChar = new LongestSubStringwithoutRepeChar();
        System.out.println(longestSubStringwithoutRepeChar.lengthOfLongestSubstring(s));

    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return 1;
        }
        Map<String, Integer> subStringMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 0; i <= len - 1; i++) {
            String subString = s.charAt(i) + "";
            subStringMap.put(subString, subString.length());
            for (int j = i + 1; j <= len - 1; j++) {
                subString = subString.concat(s.charAt(j) + "");
                if (!isRepeating(subString)) {
                    subStringMap.put(subString, subString.length());
                }
            }
        }
        Iterator<String> iterator = subStringMap.keySet().iterator();
        return iterator.hasNext() ? iterator.next().length() : 0;
    }

    /**
     * Trying better approach
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringB(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, i=0, j=0;
        int length = s.length();
        while(i<length && j<length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

    private Boolean isRepeating(String s) {
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            if (temp.contains(s.charAt(i))) {
                return true;
            }
            temp.add(s.charAt(i));
        }
        return false;
    }
}
