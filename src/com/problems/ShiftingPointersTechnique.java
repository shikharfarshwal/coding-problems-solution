package com.problems;

public class ShiftingPointersTechnique {

  /*
  LeetCode : Container with most water problem
  Shifting pointer technique
   */
  public static void main(String[] args) {
    int[] heights = new int[]{4,8,1,2,3,9};
    int p1 = 0;
    int p2 = heights.length - 1;
    int maxArea = 0;


    while (p1 < p2) {
      int height = Math.min(heights[p1], heights[p2]);
      int width = p2 - p1;
      int area = height * width;
      maxArea = Math.max(maxArea, area);

      if (heights[p1] <= heights[p2]) {
        p1++;
      } else {
        p2--;
      }
    }
    System.out.println("max Area is :- { " + maxArea + " }");
  }
}
