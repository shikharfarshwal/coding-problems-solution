package com.old.code;

import java.util.Scanner;

/**
 * Created by Shikhar on 23-02-2019.
 */
// " SHIK" --> "KIHS
public class ReverseStringUsingRecursion {


    /**
     * Using iteration
     * @param input
     */
    private static void reverseString(String input) {
        char[] inputArray = input.toCharArray();
        int length = inputArray.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            stringBuilder.append(inputArray[i]);
        }
        System.out.println("Reverse string is " + stringBuilder);
    }

    /**
     * My 1 Approach
     *
     * @param input
     * @return
     */
    private static String reverseRecursion(String input) {
        int length = input.length();
        if (length < 2) {
            return input;
        }
        char[] chars = input.toCharArray();
        char lastChar = chars[length - 1];
        String lastElement = "" + lastChar;
        String remainingString = input.substring(0, length - 1);
        return lastElement + reverseRecursion(remainingString);
    }

    /**
     * Far better approach code is cleaner .
     * @param input
     * @return
     */
    private static String reverseRecursionAndrei(String input) {
        if (input.isEmpty()) {
            return "";
        } else {
            return reverseRecursionAndrei(input.substring(1)) + input.charAt(0);

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to be reversed");
        //reverseString(scanner.next());
        //String reverseRecursion = reverseRecursion(scanner.next());
        //System.out.println(reverseRecursion);
        String reverseRecursionAndrei = reverseRecursionAndrei(scanner.next());
        System.out.println(reverseRecursionAndrei);

    }
}
