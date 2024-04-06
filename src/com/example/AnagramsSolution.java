package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramsSolution {

  //Input: strs = ["eat","tea","tan","ate","nat","bat"]
  //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
  // Map<String , List<String>>
  // [{'aet' , ['eat']} ]
  // [{'aet' , ['eat', 'tea']}]
  // [{'aet' , ['eat', 'tea']} , {'ant' , []}]
  // [{'aet' , ['eat', 'tea' , 'ate']} , {'ant' , [tan]}]
  // [{'aet' , ['eat', 'tea' , 'ate']} , {'ant' , ['tan',nat]}]
  // [{'aet' , ['eat', 'tea' , 'ate']} , {'ant' , ['tan',nat]} , {'bat', ['bat']}]

  /**
   * Time Complexity: O(NK \log K)O(NKlogK), where NN is the length of strs, and KK is the maximum length of a string in strs. The outer loop has complexity O(N)O(N) as we iterate through each string. Then, we sort each string in O(K \log K)O(KlogK) time.
   * <p>
   * Space Complexity: O(NK)O(NK), the total information content stored in ans.
   */

  private static List<List<String>> groupAnagrams(String[] words) {
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
    // sorting to return in exactly the same order as asked by the interviewer otherwise you can return new ArrayList<>(anagramMap.values())
    lists.sort((o1, o2) -> o1.size() < o2.size() ? -1 : 1);

    return lists;
  }


  public static void main(String[] args) {
    AnagramsSolution as = new AnagramsSolution();
    String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(as.groupAnagrams(str));
  }
}
