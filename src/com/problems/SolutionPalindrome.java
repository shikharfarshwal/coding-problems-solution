package com.problems;

import java.util.Stack;


/**
 * GuideWire Codility test
 * Java 8
 * <p>
 * Write a function solution that, given a string S of length N, returns any palindrome which can be obtained by replacing all of the question marks in S by lowercase letters ('a'-'z'). If no palindrome can be obtained, the function should return the string "NO".
 * <p>
 * A palindrome is a string that reads the same both forwards and backwards. Some examples of palindromes are: "kayak", "radar", "mom".
 * <p>
 * Examples:
 * <p>
 * 1. Given S = "?ab??a", the nction should return "aabbaa".
 * <p>
 * 2. Given S = "bab??a", the function should return "NO".
 * <p>
 * 3. Given S = "?a?", the function may return "aaa". It may also return "zaz", among other possible answers.
 * <p>
 * Assume that:
 * <p>
 * • Nis an integer within the range [1..1,000]; atrina con into enlaflarnarannan latar la
 */
public class SolutionPalindrome {


    public static void main(String[] args) {
        final String solution = solution("ab??b?a");
        System.out.println("final result " + solution);
    }


    public static String solution(String S) {
        final Stack<Character> inputStack = new Stack<>();
        final StringBuilder palindromeNo = new StringBuilder();
        for (int j = 0; j <= S.length() - 1; j++) {
            inputStack.push(S.charAt(j));
        }
        System.out.println("inputStack size is : " + inputStack.size() + "output is " + inputStack);
        System.out.println("palindromeNo is " + palindromeNo);
        for (int i = 0; i <= S.length() - 1; i++) {
            if (S.charAt(i) == '?' && inputStack.peek() == '?') {
                final Character pop = inputStack.pop();
                System.out.println("element popped in 1 condition is " + pop);
                palindromeNo.append('a');
                System.out.println("palindromeNo is " + palindromeNo);
            } else if (S.charAt(i) == '?' && inputStack.peek() != '?') {
                System.out.println("element popped in 2 condition is " + inputStack.peek());
                palindromeNo.append(inputStack.pop());
                System.out.println("palindromeNo is " + palindromeNo);
            } else if (S.charAt(i) != '?' && inputStack.peek() == '?') {
                final Character pop = inputStack.pop();
                System.out.println("element popped in 3 condition is " + pop);
                palindromeNo.append(S.charAt(i));
                System.out.println("palindromeNo is " + palindromeNo);
            } else if (S.charAt(i) == inputStack.peek()) {
                final Character pop = inputStack.pop();
                System.out.println("element popped in 4 condition is " + pop);
                palindromeNo.append(S.charAt(i));
                System.out.println("palindromeNo is " + palindromeNo);
            } else if (S.charAt(i) != inputStack.peek()) {
                return "NO";
            }
        }
        return palindromeNo.toString();
    }
}
