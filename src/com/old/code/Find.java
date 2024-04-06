package com.old.code;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 08-04-2018.
 */
public class Find {

    public static void main(String[] args) {
       // find();
        int[] odd = odd(2, 5);
        Stream.of(odd).forEach(System.out::println);
    }

    private static int[] odd(int l, int r) {
        int i=0;
        for(int l1=l; l1<=r; l1++){

            if(l1%2!=0){
                i++;
            }
        }
        int[] oddNo=new int[i];
        i=0;
        for(int l1=l; l1<=r; l1++){
            if(l1%2!=0){
                oddNo[i]=l1;
                i++;
            }
        }

        return oddNo;
    }

    private static void find() {
        int[] arr={1,2,3,4,5,6};
        int[] asdas= new int[5];
        int k=1;
        boolean b = Stream.of(arr).flatMapToInt(Arrays::stream).anyMatch(p -> p==k);
        System.out.println(b?"YES":"NO");
    }
}
