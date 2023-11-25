package com.example;

import java.util.Arrays;
import java.util.List;

public class Test123 {


  public static void main(String[] args) {

    countDecreasingRatings(Arrays.asList(2,1,3));
  }


  public static long countDecreasingRatings(List<Integer> ratings) {

    int count = 0;
    for (int i = 0; i <= ratings.size() - 1; i++) {
      int previous = ratings.get(i);
      count++;
      for (int j = i + 1; j <= ratings.size() - 1; j++) {
        if ((ratings.get(i) - ratings.get(j)) == 1){
          count++;
          previous = j;
        }
        else if((previous - ratings.get(j)) == 1){
          count ++;
          previous = j;
        }else {
          break;
        }
      }
    }
    return count;

  }


}
