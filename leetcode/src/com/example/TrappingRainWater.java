package com.example;

public class TrappingRainWater {


/*  public static void main(String[] args) {
//    int[] arr = new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
    int[] arr = new int[]{4, 2, 0, 3, 2, 5};

    int totalWater = 0;
    for (int i = 0; i < arr.length; i++) {
      int currentCapacity = Math.min(maxR(arr, i), maxL(arr, i)) - arr[i];
      totalWater = totalWater + currentCapacity;
    }

    System.out.println("total water " + totalWater);
  }*/

  public static int maxR(int[] arr, int currentPost) {
    int max = arr[currentPost];
    while (currentPost < arr.length) {
      max = Math.max(max, arr[currentPost]);
      currentPost++;
    }
    return max;
  }

  public static int maxL(int[] arr, int currentPost) {
    int max = arr[currentPost];
    while (currentPost >= 0) {
      max = Math.max(max, arr[currentPost]);
      currentPost--;
    }
    return max;
  }


  //current Water = min(maxLeft , maxRight) - currentHeight
  //optimized solution
// time O(N) / space O(1)
  /*
  1.Identify pointer with lesser value
  2. Is this pointer value lesser than or equal to max on that side
    yes -> update max on that side
    no -> get water for pointer value, add to total

   3. move pointer inwards
   4. repeat for other pointer.
   */

  public static void main(String[] args) {
    int[] heights = new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
    final int i = calculateTotalTrappingWater(heights);
    System.out.println("total water { " + i + " }");
  }

  private static int calculateTotalTrappingWater(int[] heights) {
    int maxLeft = 0;
    int maxRight = 0;
    int total = 0;

    int p1 = 0;
    int p2 = heights.length - 1;

    while (p1 < p2) {
      if (heights[p1] <= heights[p2]) {
        if (heights[p1] >= maxLeft) {
          maxLeft = heights[p1];
        } else {
          total += maxLeft - heights[p1];
        }
        p1++;
      } else {
        if (heights[p2] >= maxRight) {
          maxRight = heights[p2];
        } else {
          total += maxRight - heights[p2];
        }
        p2--;
      }

    }
    return total;
  }


}
