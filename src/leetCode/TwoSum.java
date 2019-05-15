package leetCode;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 30-03-2019.
 */
public class TwoSum {

    private int[] twoSum(int[] nums, int target) {
        int j = nums.length-1;
        int i = 0;
        while (i < nums.length) {
            if (j == i) {
                i++;
                j = nums.length-1;
            }
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return Stream.of(i,j).mapToInt(a->a).toArray();
            } else {
                j--;
            }
        }
        return null;
    }

    private static Supplier<int[]> getDigits  = () -> Stream.of(3,2,4).mapToInt(a->a).toArray();

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(getDigits.get(), 6)));
    }
}
