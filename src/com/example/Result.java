package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {


    public static long carParkingRoof(List<Long> cars, int k) {
        if (cars.size() >= 1 && cars.size() <= 1000000) {
            Collections.sort(cars);
            final Long max_parking_size = cars.stream().max((aLong, anotherLong) -> aLong.compareTo(anotherLong)).get();
            int totalCarsCovered = 0;
            int initialParkedCarFound = 0;
            int carCoveredIndex = 0;
            final long[] parkingLot = new long[max_parking_size.intValue()];
            int minRoofLength = parkingLot.length;


            for (int i = 0; i <= parkingLot.length - 1; i++) {
                if (cars.contains((long) i)) {
                    if (initialParkedCarFound == 0) {
                        initialParkedCarFound = i - 1;
                    }
                    totalCarsCovered++;
                    carCoveredIndex = i - 1;

                    if (totalCarsCovered >= k) {
                        int minRoofLength1 = carCoveredIndex - initialParkedCarFound;
                        if (minRoofLength1 < minRoofLength) {
                            minRoofLength = minRoofLength1 + 1;
                        }
                    }
                }

            }
            return minRoofLength;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {


        List<Long> longs = new ArrayList<>();
        longs.add(Long.valueOf(2));
        longs.add(Long.valueOf(10));
        longs.add(Long.valueOf(8));
        longs.add(Long.valueOf(17));
        long result = Result.carParkingRoof(longs, 3);
    }
}
