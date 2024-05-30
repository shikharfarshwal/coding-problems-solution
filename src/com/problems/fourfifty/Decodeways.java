package com.problems.fourfifty;

import java.util.Arrays;

/*
A few days back, Ninja encountered a string containing characters from ‘A’ to ‘Z’ which indicated a secret message. For security purposes he encoded each character of the string to its numeric value, that is, A = 1, B = 2, C = 3, till Z = 26 and combined them as a single sequence (SEQ) of digits of length N. Let's say the message was "LA", Ninja encoded it as 121 for L=12 and A=1.
Today, when he read the encoded secret message, he realised that he was not able to decode the original string. So, the Ninja is wondering in how many ways he can decode the numeric sequence to some valid string.
A valid string is a string with characters from A to Z and no other characters.
Example:
Let the encoded sequence be 121, The first way to decode 121 is: 1 = A 2 = B 1 = A Thus, the decoded string will be ABA. The second way to decode 121 is: 12 = L 1 = A Thus, the decoded string will be LA. The third way to decode 121 is: 1 = A 21 = U Thus, the decoded string will be AU. So, there will be 3 ways to decode the sequence 121 i.e. [(ABA), (LA), (AU)].
 */
public class Decodeways {

    public static void main(String[] args) {
        String s = "120312592329"; //121
        int[] mem = new int[s.length() + 1];
        Arrays.fill(mem, -1);
        int ways = decodeWays(s, 0, mem);
        System.out.println(ways);
    }

    // dp[i] = dp[i+1] + dp[i +2]
    public static int decodeWays(String s, int index, int[] mem) {

        if (index == s.length()) {
            System.out.println("return 1");
            return 1;
        }

        if (mem[index] != -1) {
            System.out.println("return " + mem[index]);
            return mem[index];
        }

        if (s.charAt(index) == '0') {
            System.out.println("return 0");
            return 0; // This decoding is invalid
        }

        int ways = decodeWays(s, index + 1, mem);

        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += decodeWays(s, index + 2, mem);
        }

        return mem[index] = ways;

    }
}
