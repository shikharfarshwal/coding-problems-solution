import java.util.Scanner;

/**
 * Created by Shikhar on 22-02-2019.
 */
public class FibonacciIndexValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f1 = 0;
        int f2 = 1;
        //System.out.println(f1);
        //System.out.println(f2);
        //System.out.println("For number " + n + " the index value is " + getFibonacciIndexValue(n, f1, f2));
        System.out.println("For number " + n + " the index value is " + getFibonacciIndexValueUsingRecursion(n));

    }

    private static int getFibonacciIndexValue(int indexValue, int f1, int f2) {
        if (indexValue != 0) {
            int count = indexValue - 1;
            for (int i = 0; i < indexValue - 1; i++) {
                int f3 = f1 + f2;
                System.out.println("count is " + count + " and fibonacci number is " + f3);
                f1 = f2;
                f2 = f3;
                count--;
                if (count == 0) {
                    return f3;
                }
            }
        }
        return 0;
    }

    private static int getFibonacciIndexValueUsingRecursion(int indexValue) {
        if (indexValue < 2) {
            return indexValue;
        }
        return getFibonacciIndexValueUsingRecursion(indexValue - 1) + getFibonacciIndexValueUsingRecursion(indexValue - 2);
    }

}
