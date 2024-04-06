package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MedianArray {

    // find median of two sorted array 1,2,3,4
    //1,2,3
    public static void main(String[] args) {
        MedianArray medianArray = new MedianArray();
        System.out.println(medianArray.median(new int[]{}, new int[]{1}));
    }

    double median(int[] a1, int[] a2) {
        final BigDecimal median1 = new BigDecimal(median(a1));
        final BigDecimal median2 = new BigDecimal(median(a2));
        final BigDecimal bigDecimal3 = median1.add(median2);
        return bigDecimal3.divide(new BigDecimal(2), 1, RoundingMode.CEILING).doubleValue();
    }


    private double median(int[] a1) {
        if (a1.length != 0) {
            if (a1.length % 2 == 0) {
                final BigDecimal b1 = new BigDecimal(a1[a1.length / 2]);
                final BigDecimal b2 = new BigDecimal(a1[(a1.length / 2) - 1]);
                final BigDecimal b3 = b1.add(b2);
                return b3.divide(new BigDecimal(2), 1, RoundingMode.CEILING).doubleValue();
            } else {
                return new BigDecimal(a1[a1.length / 2]).doubleValue();
            }
        }
        return 0;
    }
}
