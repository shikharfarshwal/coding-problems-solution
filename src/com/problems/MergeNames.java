package com.problems;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        final Set<String> setOfNames1 = Arrays.stream(names1)
                .collect(Collectors.toSet());

        final Set<String> setOfNames2 = Arrays.stream(names2).collect(Collectors.toSet());
        setOfNames1.addAll(setOfNames2);
        return setOfNames1.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}