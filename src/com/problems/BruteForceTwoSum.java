package com.problems;

public class BruteForceTwoSum {


  public static void main(String[] args) {
    final int[] arr = new int[]{1, 3, 7, 9, 2};
    int target = 11;

    for (int i = 0; i <= arr.length - 1; i++) {
      int p1 = arr[i];
      int number2 = target - p1;
      for (int p2 = i + 1; p2 <= arr.length - 1; p2++) {
        if (arr[p2] == number2) {
          System.out.println("indices are " + "[ " + i + "," + p2 + " ]");
        }
      }
    }
  }
}
