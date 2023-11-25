package com.example;

public class ShiftingPointersTechnique {

  /*
  LeetCode : Container with most water problem
   */
  public static void main(String[] args) {
    int[] heights = new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
    int p1 = 0;
    int p2 = heights.length - 1;
    int maxArea = 0;


    while (p1 < p2) {
      int height = Math.min(heights[p1], heights[p2]);
      int width = p2 - p1;
      int area = height * width;
      maxArea = Math.max(maxArea, area);

      if (heights[p1] >= heights[p2]) {
        p1++;
      } else {
        p2--;
      }
    }
    System.out.println("max Area is :- { " + maxArea + " }");
    ;
  }
}
