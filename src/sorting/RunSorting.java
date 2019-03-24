package sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by Shikhar on 08-03-2019.
 */
public class RunSorting {

    private static Consumer<Integer> printSortedArray = System.out::println;

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        int[] unsortedArray = initializeArray();
        System.out.println("Before Sorting");
        Arrays.stream(unsortedArray).boxed().forEach(printSortedArray);
        //bubbleSort.sort(unsortedArray);
        selectionSort.sort(unsortedArray);
        System.out.println("After Sorting");
        Arrays.stream(unsortedArray).boxed().forEach(printSortedArray);
    }


    private static int[] initializeArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = scanner.nextInt();
        int[] unsortedArray = new int[n];
        System.out.println("Enter elements in array");
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = scanner.nextInt();
        }
        return unsortedArray;
    }
}
