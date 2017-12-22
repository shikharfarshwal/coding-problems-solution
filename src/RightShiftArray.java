import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a JAVA program to right shift an array by noToShift times
 */
public class RightShiftArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sizeOfArray = in.nextInt();
        int noToShift = in.nextInt();

        int arrayToBeRightShift[] = new int[sizeOfArray];//[1,2,3,4,5]
        for (int a_i = 0; a_i < sizeOfArray; a_i++) {
            arrayToBeRightShift[a_i] = in.nextInt();
        }
        swapArraysElements(noToShift, arrayToBeRightShift);
        Arrays.stream(arrayToBeRightShift).forEach(p -> System.out.print(p + " "));

    }

    private static void swapArraysElements(int k, int[] arrayToBeRightShift) {
        int temp;
        for (int i = 0; i <= k - 1; i++) {
            for (int j = 0; j < arrayToBeRightShift.length - 1; j++) {
                temp = arrayToBeRightShift[j];
                arrayToBeRightShift[j] = arrayToBeRightShift[j + 1];
                arrayToBeRightShift[j + 1] = temp;
            }
        }
    }

}
