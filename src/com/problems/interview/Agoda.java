package com.problems.interview;

import java.util.Arrays;
import java.util.List;


// need to find 3 elements in an array that sum up to 0 (a+b+c)=0
// duplicate elements can also be there
// array size can be zero
// min 3 elements shall be there
// [-7, 11,40,3,1,-4]
public class Agoda {

    public static boolean solution(List<Integer> num) {

        if (num.size() == 0) {
            return false;
        }
        // Write your code here
        Integer[] nums = num.toArray(new Integer[0]);

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                //nums.get(i)
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    return true;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
                // -1, -1, -1, 0, 1, 1
            }
        }
        return false;
    }

}
