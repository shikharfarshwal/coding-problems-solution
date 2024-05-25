package com.problems;

public class LongestSubstring {

  public static void main(String[] args) {
    String str = "abccdbe";

    // a , b , c,
    String temp = "";
    int count = 0;
    char[] arr = str.toCharArray();
    int longest = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (temp.contains(String.valueOf(arr[j]))) {
          temp = "";
          if (count > longest) {
            longest = count;
          }
          break;
        } else {
          temp = temp.concat(String.valueOf(arr[j]));
          count++;
          if (count > longest) {
            longest = count;
          }
        }
      }
      count = 0;
    }
    System.out.println(longest);
  }
}
