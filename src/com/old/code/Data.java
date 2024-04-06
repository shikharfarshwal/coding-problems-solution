package com.old.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shikhar on 20-06-2018.
 */


class CustomSort {
     static class Data implements Comparable<Data> {
        int value,count,index;

        public Data(int value, int count, int index) {
            this.value = value;
            this.count = count;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            if(this.count!=o.count){
                return o.count -this.count;
            }
            else{
                return this.index-o.index;
            }


        }
    }
     public static void customSort(int[] arr){
         if(arr == null || arr.length <2)
             return;

         Map<Integer,Data> hm =new HashMap<>();
         Data data =null;
         for(int i=0;i<arr.length;i++){
             data=hm.get(arr[i]);

             if(data ==null) {
                 hm.put(arr[i], new Data(arr[i], 1, i));
             }
             else{
                data.count++;
                 }
             }
         Object[] array = hm.values().toArray();
         Arrays.sort(array);
         int k =0;
         for(int i=0;i<array.length;i++){
             data=(Data)array[i];
             for(int j=0; j<data.count;j++){
                 arr[k++] = data.value;
             }
     }
         Arrays.stream(arr).boxed().sorted(Comparator.comparing(a->a)).forEach(System.out::println);
     }

    public static void main(String[] args) {
        int arr[]={3,3,1,1,1,8,3,6,8,7,8};
        CustomSort.customSort(arr);
        for(int x:arr){
            System.out.println(x+ " ");
        }
    }
}
