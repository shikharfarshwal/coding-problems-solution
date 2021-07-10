package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 *
 * no ingredeints? 3
 * no of each ingredient to create ppf
 *  2 5 4
 *
 *  stock in lab
 *  20 40 90
 *
 * PPF
 * 8 ingredients
 * i1 = 1
 * i2 = 1
 * i3 = 1
 * -
 * -
 * -
 * i8
 * 1 ppf
 *
 * i1 = 10
 * i2 = 10
 * i3 =10
 */
public class CandidateCode {

    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(System.in);
        final int ingredientsNumber = in.nextInt();
        final List<Integer> requiredIngredientsArray = new ArrayList<>();
        final List<Integer> stockedIngredientsArray = new ArrayList<>();

        BufferedReader br = null;
        BufferedReader br1 = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tokenizer = new StringTokenizer((br.readLine()));
            while (tokenizer != null && tokenizer.hasMoreElements()) {
                requiredIngredientsArray.add(Integer.parseInt(tokenizer.nextToken()));
            }


            br1 = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tokenizer1 = new StringTokenizer((br1.readLine()));
            while (tokenizer != null && tokenizer.hasMoreElements()) {
                stockedIngredientsArray.add(Integer.parseInt(tokenizer.nextToken()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Queue<Integer> ingredientQueue = new LinkedList<>(requiredIngredientsArray);
        Queue<Integer> quantityQueue = new LinkedList<>(stockedIngredientsArray);

        CandidateCode candidateCode = new CandidateCode();
        final int powerPuffGirls = candidateCode.generatePowerPuffGirls(ingredientQueue, quantityQueue);
        System.out.println(powerPuffGirls);
    }


    private int generatePowerPuffGirls(final Queue<Integer> ingredientQueue,
                                       final Queue<Integer> quantityQueue) {
        int cycle = 0;
        int count = 0;
        while (0 != quantityQueue.peek()) {
            if (count == 4) {
                cycle++;
                count = 0;
            }
            final Integer removedIngredient = ingredientQueue.remove();
            final Integer removedQuantityElement = quantityQueue.remove();
            final int result = Math.subtractExact(removedQuantityElement, removedIngredient);
            quantityQueue.add(result);
            ingredientQueue.add(removedIngredient);
            count++;
        }
        return cycle;
    }
}
