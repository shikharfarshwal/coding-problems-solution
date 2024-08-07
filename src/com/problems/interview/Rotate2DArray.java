package com.problems.interview;

public class Rotate2DArray {


  // After transpose we swap elements of
  // column one by one for finding left
  // rotation of matrix by 90 degree
  static void reverseColumns(int arr[][]) {
    for (int i = 0; i < arr[0].length; i++)
      for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) {
        int temp = arr[j][i];
        arr[j][i] = arr[k][i];
        arr[k][i] = temp;
      }
  }

  // Function for do transpose of matrix
  static void transpose(int arr[][]) {
    for (int i = 0; i < arr.length; i++)
      for (int j = i; j < arr[0].length; j++) {
        int temp = arr[j][i];
        arr[j][i] = arr[i][j];
        arr[i][j] = temp;
      }
  }

  // Function for print matrix
  static void printMatrix(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++)
        System.out.print(arr[i][j] + " ");
      System.out.println("");
    }
  }

  // Function to anticlockwise rotate
  // matrix by 90 degree
  static void rotateLeft90(int arr[][]) {
    transpose(arr);
    System.out.println("transpose");
    printMatrix(arr);
    System.out.println("");
    reverseColumns(arr);
  }

  /* Driver program to test above function */
  public static void main(String[] args) {
    /*final Double aDouble = Double.valueOf("");
    int arr[][] = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

    rotateLeft90(arr);
    printMatrix(arr);*/


  }

}