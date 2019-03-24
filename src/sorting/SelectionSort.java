package sorting;

/**
 * Created by Shikhar on 08-03-2019.
 */
public class SelectionSort implements CustomSorting<int[]> {

    @Override
    public void sort(int[] unsortedArray) {
        int length = unsortedArray.length;
        for (int i = 0; i < length; i++) {
            int temp = unsortedArray[i];
            int assumedSmallestElementIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (unsortedArray[j] < unsortedArray[assumedSmallestElementIndex]) {
                    assumedSmallestElementIndex = j;
                }
            }
            unsortedArray[i] = unsortedArray[assumedSmallestElementIndex];
            unsortedArray[assumedSmallestElementIndex] = temp;
        }
    }
}
