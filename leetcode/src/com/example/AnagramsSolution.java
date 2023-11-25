package com.example;

import java.util.*;
import java.util.stream.Stream;

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
   *
   * Space Complexity: O(NK)O(NK), the total information content stored in ans.
  */

  public List<List<String>> groupAnagrams(final String[] strs) {

    final Map<String, List<String>> anagramsMap = new HashMap<>();
    for (final String word : strs) {
      final char[] chars = word.toCharArray();
      final String sortedWord = Stream.of(chars).map(String::new).findAny().get();
     // final String sortedWord = String.valueOf(chars);
      if (anagramsMap.containsKey(sortedWord)) {
        final List<String> anagrams = anagramsMap.get(sortedWord);
        final List<String> anagramsNew = new ArrayList<>(anagrams);
        anagramsNew.add(word);
        anagramsMap.put(sortedWord, anagramsNew);
      } else {
        anagramsMap.put(sortedWord, Collections.singletonList(word));
      }
    }
    return new ArrayList<>(anagramsMap.values());
  }


  public static void main(String[] args) {
    AnagramsSolution as = new AnagramsSolution();
    String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(as.groupAnagrams(str));
  }
}
