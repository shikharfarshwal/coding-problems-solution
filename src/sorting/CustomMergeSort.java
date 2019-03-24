package sorting;

/**
 * Created by Shikhar on 11-03-2019.
 */
public class CustomMergeSort implements CustomSorting<int[]> {


    @Override
    public void sort(int[] unsortedArray) {

    }


    private int[] mergeSort(int[] unsortedArray) {
        int length = unsortedArray.length;
        if (length == 1) {
            return unsortedArray;
        }
        //splitting array into two halves
        int median = (length / 2);
        int secondHalf = length - median;
        int[] left = new int[median];
        int[] right = new int[secondHalf];
        initializeArray(unsortedArray, left);
        initializeArray(unsortedArray, right);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int tempLength = left.length + right.length;
        int[] temp = new int[tempLength];
        if (left[0] > right[0]) {
            temp[0] = right[0];
            temp[1] = left[0];
            return temp;
        } else {
            temp[0] = left[0];
            temp[1] = right[0];
            return temp;
        }
    }

    private void initializeArray(int[] unSortedArray, int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] = unSortedArray[i];
        }
    }
}
