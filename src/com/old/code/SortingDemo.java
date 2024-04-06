package com.old.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shikhar on 03-03-2019.
 */
public class SortingDemo {


    public static void main(String[] args) {
        List<Integer> baskets = Arrays.asList(2, 65, 34, 2, 1, 7, 8);
        List<Character> letters = Arrays.asList('a', 'd', 'z', 'e', 'r', 'b');
        Collections.sort(baskets);
        baskets.forEach(System.out::print);
        Collections.sort(letters);
        letters.forEach(System.out::print);

    }
}
