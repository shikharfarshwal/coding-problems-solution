package com.old.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 02-04-2019.
 */
public class Hck5 {

    public static long countSum(List<Integer> numbers) {
        // Write your code here
        List<Integer> result= new ArrayList<>();
        for (Integer number :
                numbers) {
            List<Integer> integerList = printDivisors(number);
            int[] oddNUmber = getOddNUmber(integerList);
            result.add(Arrays.stream(oddNUmber).sum());
        }
        return result.stream().mapToInt(value -> value).sum();
    }

    private static List<Integer> printDivisors(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    //return Stream.of(i).mapToInt(a -> a).toArray();
                    result.add(i);
                }
                else {
                    //Stream.of(i, n / i).mapToInt(a -> a).toArray();
                    result.add(i);
                    result.add(n / i);
                }
            }
        }
        return result;
    }

    private static int[] getOddNUmber(List<Integer> n){
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<n.size();i++){
            if(n.get(i)%2 !=0){
                result.add(n.get(i));
            }
        }
        return result.stream().mapToInt(a->a).toArray();
    }

    public static void main(String[] args) {

        System.out.println(countSum(Arrays.asList(1,6,10)));

    }
}
