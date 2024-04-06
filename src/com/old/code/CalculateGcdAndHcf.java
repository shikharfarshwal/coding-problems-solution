package com.old.code;

import java.util.Scanner;

/**
 * Created by Shikhar on 11-11-2018.
 */
public class CalculateGcdAndHcf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double divident = sc.nextDouble();
        double divisior = sc.nextDouble();
        double rem=0;
        do {
            rem = divident % divisior;
            divident=divisior;
            divisior=rem;
        }while(rem!=0);
        System.out.println("Hcf or Gcd is = "+divident);
    }
}
