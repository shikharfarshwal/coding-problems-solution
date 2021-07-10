package com.leetcode;

public class ReverseInteger {
    //x =123 answr = 321


    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));//214748364
        //1534236469
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int remainder = (x % 10);
            x = (x / 10);
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            rev = rev * 10 + remainder;
        }
        return rev;
    }
}
