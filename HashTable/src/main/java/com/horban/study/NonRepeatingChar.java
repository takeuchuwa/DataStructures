package com.horban.study;

import java.util.*;

public class NonRepeatingChar {

    public static Character firstNonRepeatingChar(String chars) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            characterCounts.put(chars.charAt(i), characterCounts.getOrDefault(chars.charAt(i), 0) + 1);
        }
        for (int i = 0; i < chars.length(); i++) {
            Character letter = chars.charAt(i);
            if (characterCounts.get(letter) == 1) {
                return letter;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }
}
