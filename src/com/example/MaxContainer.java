package com.example;

import java.util.Arrays;

// find max area that forms a container to hold the water
//[4,8,1,2,3,9]
public class MaxContainer {


  public static void main(String[] args) {
    final int areaFromContainer = findAreaFromContainer(new int[]{4, 8, 1, 2, 3, 9});
    System.out.println("maxArea is = " + areaFromContainer);
  }

  public static int findAreaFromContainer(final int[] arr) {
    int maxArea = 0;
    final int p2 = arr.length - 1;
    for (int p1 = 0; p1 < arr.length; p1++) {
      int area = Math.min(arr[p1], arr[p2]) * Math.subtractExact(p2, p1);
      if (area > maxArea) {
        maxArea = area;
      }
    }
    return maxArea;
  }
}
