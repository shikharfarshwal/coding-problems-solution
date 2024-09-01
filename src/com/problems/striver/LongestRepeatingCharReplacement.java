package com.problems.striver;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        String str = "AAABBCCD";
        System.out.println(longestRepeatingCharReplacement(str.toCharArray(), 2));
        System.out.println(longestRepeatingCharReplacementEfficient(str.toCharArray(), 2));
    }


    // O(N) * O(N) + 26= O(N^2) * 26
    public static int longestRepeatingCharReplacement(char[] arr, int k) {
        int maxF = 0;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int[] hash = new int[26];

        while (r < arr.length) { // O(N)
            hash[arr[r] - 'A']++;
            maxF = Math.max(maxF, hash[arr[r] - 'A']);

            // shrink the window by moving the l pointer closer towards r
            while ((r - l + 1) - maxF > k) { // O(N)
                hash[arr[l] - 'A']--;
                maxF = 0;
                for (int i = 0; i < 25; i++) { // O(25)
                    maxF = Math.max(maxF, hash[i]);
                }
                // i need to update my maxfrequency var as well? coz now a has become from 3-->2 hence maxF shall also be reduced from 3-->2. right ?
                l++;
            }

            if ((r - l + 1) - maxF <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }
        return maxLen;
    }


    public static int longestRepeatingCharReplacementEfficient(char[] arr, int k) {
        int maxF = 0;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int[] hash = new int[26];

        while (r < arr.length) { // O(N)
            hash[arr[r] - 'A']++;
            maxF = Math.max(maxF, hash[arr[r] - 'A']);

            // shrink the window by moving the l pointer closer towards r
            if ((r - l + 1) - maxF > k) { // O(N)
                hash[arr[l] - 'A']--;
                // ther eis no point in trimming down maxf ciz if already maxf=3 then trimming this down will never give me the maxlen acc to formula lan-maxf <=k  if maxf her eis decreasing then it will increase the overall sum and will never give me an answer greater maxlen
                l++;
            }

            if ((r - l + 1) - maxF <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }
        return maxLen;
    }
}
