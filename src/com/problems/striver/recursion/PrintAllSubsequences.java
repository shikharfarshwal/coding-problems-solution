package com.problems.striver.recursion;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=AxNNVECce8c&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=6
public class PrintAllSubsequences {


    public static void main(String[] args) {
        subsequences(0 , 3 , new ArrayList<>() , new int[]{3,2,1});
    }

    public static void subsequences(int index, int n, List<Integer> sequences, int[] arr) {
        if (index == n) {
            sequences.forEach(System.out::println);
            return;
        }
        sequences.add(arr[index]); // take an input
        subsequences(index + 1, n, sequences, arr);
        sequences.remove(sequences.size() -1);// not take an input, this element is not added to the subsequence
        subsequences(index + 1, n, sequences, arr);
    }
}
