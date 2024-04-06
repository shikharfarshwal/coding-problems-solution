package com.old.code;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

 class Stats {

   static Map<String,List<Double>> collectionOfPrices=new HashMap<>();

    public static class StatisticsAggregatorImpl implements StatisticsAggregator {

        @Override
        public void putNewPrice(String symbol, double price) {
            List<Double> pricesListCorrespondingToASymbol=new ArrayList<>();
            if(collectionOfPrices.containsKey(symbol)){
                List<Double> symbolInDataStructure = collectionOfPrices.get(symbol);
                if(!symbolInDataStructure.isEmpty()){
                    symbolInDataStructure.add(price);
                }
                else
                {
                    pricesListCorrespondingToASymbol.add(price);
                    collectionOfPrices.put(symbol,pricesListCorrespondingToASymbol);
                }
            }
            else{
                pricesListCorrespondingToASymbol.add(price);
                collectionOfPrices.put(symbol,pricesListCorrespondingToASymbol);
            }
        }

        @Override
        public double getAveragePrice(String symbol) {
            DoubleSummaryStatistics summaryStatistics = collectionOfPrices.entrySet()
                    .stream()
                    .filter(f -> f.getKey().equalsIgnoreCase(symbol))
                    .map(v -> v.getValue()).flatMap(List::stream)
                    .collect(Collectors.summarizingDouble(m -> m.doubleValue()));
            return summaryStatistics.getAverage();
        }

        @Override
        public int getTickCount(String symbol) {
            long count = collectionOfPrices.entrySet()
                    .stream()
                    .filter(f -> f.getKey().equalsIgnoreCase(symbol))
                    .map(v -> v.getValue()).flatMap(List::stream).count();
            return (int) count;
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
               pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}
