package com.old.code.leetCode;

import java.util.*;

/**
 * Created by Shikhar on 05-04-2019.
 */
public class CharacterCountFromString {


    public static Map<Character,Integer> countEachCharNoFromInput(String input){
        Map<Character,Integer> charCountMap = new HashMap<>();

        char[] charArray =input.toCharArray();
        for(char c:charArray){

            if(charCountMap.containsKey(c)){
                Integer integer = charCountMap.get(c);
                charCountMap.put(c,integer +1);
            }
            else{
                charCountMap.put(c,1);
            }
        }
        return charCountMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        Map<Character, Integer> characterIntegerMap = countEachCharNoFromInput(sc.next());
        Set<Map.Entry<Character, Integer>> entries = characterIntegerMap.entrySet();
        for(Map.Entry entry:entries){
            System.out.println(entry.getKey() +" "+entry.getValue());
        }


    }
}
