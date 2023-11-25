package com.example;

public class SltnBinarySearch {


  public static void main(String[] args) {
    SltnBinarySearch sbs = new SltnBinarySearch();
    System.out.println(sbs.search(new int[]{-1,0,3,5,9,12}, 13));
  }

  /*
  Input: nums = [-1,0,3,5,9,12], target = 9
  Output: 4
  Explanation: 9 exists in nums and its index is 4
   */

  public int search(int[] nums, int target) {
    final int length = nums.length;
    return binarySearch(0, length-1, nums, target);
  }


  public int binarySearch(int start, int end, int[] nums, int target) {
    if (start <= end) {
      final int length = end + start;
      int half = length / 2;
      if (nums[half] == target) {
        return half;
      }
      if (target < nums[half]) {
        return binarySearch(start, half - 1, nums, target);
      }
      return binarySearch(half + 1, end, nums, target);
    }
    return -1;
  }
}
