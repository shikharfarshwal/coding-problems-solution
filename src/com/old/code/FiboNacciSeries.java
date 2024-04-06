package com.old.code;

import java.util.Scanner;

/**
 * Created by Shikhar on 05-07-2018.
 */
public class FiboNacciSeries {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int f1=0;
        int count = n;
        int f2=1;
        System.out.println(f1);
        System.out.println(f2);
        for(int i=0;i<n-1;i++){
            int f3=f1+f2;
            System.out.println(f3);
            f1=f2;
            f2=f3;
            count--;
        }

    }
}
