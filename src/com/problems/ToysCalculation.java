package com.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Amazon first round question
 */
public class ToysCalculation {

    public static void main(String[] args) {

        System.out.println(get());

    }

    private static List<String> get() {
        List<String> quotesList = Arrays.asList("Elmo is the hottest toy of the season","anacell","Elmo");
        List<String> toysList = Arrays.asList("Elmo","anacell","betra","cbc","dbc");
        Map<String, Integer> countOfToys = new HashMap<>();


        for (String toy : toysList) {
            countOfToys.put(toy, 0);
        }

        final Set<String> collect = quotesList.stream()
                .map(a -> a.split(" "))
                .flatMap(Stream::of)
                .collect(Collectors.toSet());

        collect.forEach(
                quotes -> {
                    toysList.forEach(toys -> {
                        if (quotes.contains(toys)) {
                            countOfToys.put(toys, (countOfToys.get(toys) + 1));
                        }
                    });
                });
        final LinkedHashMap<String, Integer> collect1 = countOfToys.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        int topToys = 1;
        List<String> topTOysLIst = new ArrayList<>();
        final Iterator<String> iterator = collect1.keySet().iterator();
        while (iterator.hasNext() && topToys != 0) {
            topTOysLIst.add(iterator.next());
            topToys--;
        }
        return topTOysLIst;

    }
}
