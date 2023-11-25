package com.example.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class PayPay {

  public static void main(String[] args) {
    final String[] arr = new String[]{"count:4", "count:6", "flip", "count:2", "flip", "count:4"};
    Arrays.stream(solution1("0000101", arr)).forEach(System.out::println);
  }

  public static int[] solution1(String binaryString, String[] requests) {
    ArrayList<Integer> result = new ArrayList();
    String flipped = "";

    for (String request : requests) {
      if (request.contains(":")) {
        final String[] splitedRequest = request.split(":");
        if (Integer.parseInt(splitedRequest[1]) >= binaryString.length()) {
          continue;
        }
        final String requestByCount = binaryString.substring(0, Integer.parseInt(splitedRequest[1]) + 1);
        int sum = 0;
        for (char digit : requestByCount.toCharArray()) {
          int iDigit = Integer.parseInt(String.valueOf(digit));
          if (iDigit == 1) {
            sum = sum + iDigit;
          }
        }
        result.add(sum);
      } else {
        char[] flipRequest = binaryString.toCharArray();
        for (int j = 0; j <= flipRequest.length - 1; j++) {
          if (flipRequest[j] == '0') {
            flipped += '1';
          } else {
            flipped += '0';
          }
        }
        System.out.println("flipped - { " + flipped + "}");
        binaryString = flipped;
      }

    }

    return result.stream().mapToInt(Integer::intValue).toArray();

  }


  public int[] solution2(int[] target) {
    final ArrayList<Integer> results = new ArrayList<>();
    for (int i = 0; i <= target.length - 1; i++) {
      if (i == 0) {
        results.add(target[i]);
        continue;
      } else if (i == target.length - 1) {
        results.add(target[i]);
        break;
      }

      int maxInNeighbours = max(target[i - 1], target[i + 1]);
      if (target[i] > maxInNeighbours) {
        results.add(target[i]);
      }
    }
    return results.stream().mapToInt(Integer::intValue).toArray();
  }


  int max(int t1, int t2) {
    if (t1 > t2) {
      return t1;
    } else {
      return t2;
    }
  }

}
