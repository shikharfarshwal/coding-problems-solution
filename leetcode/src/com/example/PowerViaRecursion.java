package com.example;

public class PowerViaRecursion {


  public static void main(String[] args) {

    final int power = power(3, 5);
    System.out.println(power);
  }

  public static int power(int base, int power) {

    if (power == 0)
      return 1;

    return base * power(base, power - 1);
  }

}
