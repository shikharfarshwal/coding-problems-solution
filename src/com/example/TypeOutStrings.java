package com.example;

import java.util.Arrays;

public class TypeOutStrings {


  //    String s1 = "ab##z";
  // x#y#z#  T: "a#" True
  // x###y  T: "a" True
  // XB###Y  T: "xb##y" false
  public static void main(String[] args) {

    String s1 = "a###z";
    String s2 = "a";
    final String string = typedOutString(s1);
    final String string2 = typedOutString(s2);
    System.out.println(string.equals(string2));

  }

  public static String typedOutString(String s) {
    int p1 = 0;
//    final StringBuilder temp = new StringBuilder();
    char[] output = new char[s.length()];
    final char[] arr = s.toCharArray();

    while (p1 <= arr.length - 1) {
      if (arr[p1] != '#') {
        output[p1] = arr[p1];
        p1++;
      } else {
        char[] proxyArray = new char[output.length - 1];
        for (int i = 0, k = 0;i < output.length; i++) {
          // check if index is crossed, continue without copying
          if (i == p1) {
            continue;
          }
          // else copy the element
          proxyArray[k++] = output[i];
          output = proxyArray;
        }
      }
    }
    return Arrays.toString(output);
  }
}
