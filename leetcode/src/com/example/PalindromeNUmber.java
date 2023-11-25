package com.example;

public class PalindromeNUmber {

    // 121
    //1001
    public boolean isPalindrome(int x) {
        int sum = 0;
        if (x < 0)
            return false;
        int z = x;
        while (x != 0) {
            int y = x % 10;
            sum = sum * 10 + y;
            x = x / 10;
        }
        if (sum == z)
            return true;

        return false;
    }


    public static void main(String[] args) {
        PalindromeNUmber palindromeNUmber = new PalindromeNUmber();
        System.out.println(palindromeNUmber.isPalindrome(1001));
    }
}
