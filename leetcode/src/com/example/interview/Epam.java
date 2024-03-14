package com.example.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Epam {
  // question 1
  // ANAGRAM Solution
  // Input: ["eat","tea","elbow","ate","below","bat"]
  // Output: [["bat"],["below","elbow"],["ate","eat","tea"]]
  // question 2
  //Input:  1->2->3->4->5->6->null
  //Output: 1->6->2->5->3->4->null

  
  private static List<List<String>> group(String[] words) {

    Map<String, List<String>> anagramMap = new HashMap<>();
    for (final String word : words) {
      final char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);
      final List<String> anagramList = anagramMap.getOrDefault(sortedWord, new ArrayList<>());
      anagramList.add(word);
      anagramMap.put(sortedWord, anagramList.stream().sorted().collect(Collectors.toList()));
    }

    final ArrayList<List<String>> lists = new ArrayList<>(anagramMap.values());
    lists.sort(new Comparator<List<String>>() {
      @Override
      public int compare(List<String> o1, List<String> o2) {
        return o1.size() < o2.size() ? -1 : 1;
      }
    });

    return lists;
  }






}
