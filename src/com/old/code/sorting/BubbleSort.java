package com.old.code.sorting;

/**
 * Created by Shikhar on 03-03-2019.
 */
public class BubbleSort implements CustomSorting<int[]> {

    @Override
    public void sort(int[] unsortedArray) {
        int length = unsortedArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (unsortedArray[i] > unsortedArray[j]) {
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[i];
                    unsortedArray[i] = temp;
                }
            }
        }
    }
}
