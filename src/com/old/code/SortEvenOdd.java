package com.old.code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Shikhar on 20-06-2018.
 */
public class SortEvenOdd {


    static int moves(int[] array_sort){
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();
        for (int i : array_sort) {
            if ((i & 1) == 1) {
                odd.add(i);
            } else {
                even.add(i);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        even.addAll(odd);
        int[] newArray;
        Integer[] integers = even.stream().toArray(Integer[]::new);
        int[] ints = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        return 1;
       /* Integer[] objects = even.stream().toArray(Integer[]::new);
        Integer[] objects1 = odd.stream().toArray(Integer[]::new);
        IntStream.concat(Arrays.stream(objects),Arrays.stream(objects1)).toArray();*/
       // return integers;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[aCount];

        for (int i = 0; i < aCount; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
        }

        int res = moves(a);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
