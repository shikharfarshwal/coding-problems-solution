package com.old.code;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 10-06-2018.
 */
public class CustomSortAnArray {


    static void customSort(int[] arr) {

        Object[] array = Arrays.stream(arr).boxed().sorted(Comparator.comparing(Function.identity())).toArray();

        Arrays.stream(array).forEach(System.out::println);

      //  System.out.println();
      //  Arrays.stream(arr).boxed().sorted(Comparator.comparing())

    }

    static void newSort(int[] arr){
        Map<Integer,List<Integer>> mapOfNo=new TreeMap<>();
        int count=0;
        for(int i=0;i<=arr.length-1;i++){
            for (int j=0;j<=arr.length-1;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
                //mapOfNo.put(count);
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        for (int i = 0; i < arrCount; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        customSort(arr);

        scanner.close();
    }
}

