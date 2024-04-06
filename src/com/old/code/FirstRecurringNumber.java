package com.old.code;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Shikhar on 02-02-2019.
 */
public class FirstRecurringNumber {

    public static void main(String[] args) {
        System.out.println("Please enter size of array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] findRecurringNumberArray = new int[n];
        if (n > 0) {
            System.out.println("Please enter elements in the array");
            for (int j = 0; j <= findRecurringNumberArray.length - 1; j++) {
                findRecurringNumberArray[j] = sc.nextInt();
            }
            Set<Integer> setOfNumbers = new HashSet<>();

            for (int i = 0; i <= findRecurringNumberArray.length - 1; i++) {
                if (!setOfNumbers.contains(findRecurringNumberArray[i])) {
                    setOfNumbers.add(findRecurringNumberArray[i]);
                } else {
                    System.out.println("First recurring element is: " + findRecurringNumberArray[i]);
                    break;
                }

            }
        }

        System.out.println("End of Program");
    }
}
