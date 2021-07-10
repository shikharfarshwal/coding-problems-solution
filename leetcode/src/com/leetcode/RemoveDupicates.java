package com.leetcode;

public class RemoveDupicates {

    public static void main(String[] args) {
        RemoveDupicates removeDupicates = new RemoveDupicates();
        int[] input = new int[10];
        input[0] = 0;
        input[1] = 0;
        input[2] = 1;
        input[3] = 1;
        input[4] = 1;
        input[5] = 2;
        input[6] = 2;
        input[7] = 3;
        input[8] = 3;
        input[9] = 4;
        System.out.println(removeDupicates.removeDuplicates(input));
    }

    /**
     * input = [1,1,2,2,3,4,4,5]
     *
     * @param input
     * @return
     */
    private int removeDuplicates(int[] input) {
        int i = 0;
        if (input.length == 0) return 0;
        for (int j = 1; j < input.length; j++) {
            if (input[i] != input[j]) {
                i++;
                input[i] = input[j];
            }
        }
        return i + 1;
    }

}
