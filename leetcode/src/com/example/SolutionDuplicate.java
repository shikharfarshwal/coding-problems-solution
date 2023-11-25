package com.example;

import java.util.HashSet;
import java.util.Set;

//[6, 2, 3, 5, 6, 3]
public class SolutionDuplicate {

    static String str;
    public SolutionDuplicate() {
        System.out.println("hello");
        str = "1";
    }

    public int solution(int[] A) {
        int j = A.length - 1;
        int count = 0;
        Set<Integer> visitedElement = new HashSet<>();
        for (int i = 0; i <= A.length-1; i++) {
            if (A[i] == A[j]) {
                A[j] = A[j] + 1;
                j--;
                count++;
                visitedElement.add(A[i]);
            } else if (visitedElement.contains(A[i])) {
                A[i] = A[i] + 1;
                j--;
                count++;
                visitedElement.add(A[i]);
            } else {
                visitedElement.add(A[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SolutionDuplicate solutionDuplicate = new SolutionDuplicate();
        System.out.println(str);
    }
}
