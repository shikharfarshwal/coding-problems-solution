package com.example;

import java.math.BigDecimal;

public class Factorial {

  /*
  5! = 5*4*3*2*1
  6! = 6*5*4*3*2*1
   */
  public BigDecimal factorial(final int fact) {
    BigDecimal sum = new BigDecimal(1);
    for (int i = fact; i > 0; i--) {
      sum = new BigDecimal(i).multiply(sum);
    }
    return sum;
  }

  public static void main(String[] args) {
    Factorial fact = new Factorial();
    System.out.println(fact.factorial(12));
  }


}
