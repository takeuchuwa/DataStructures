package com.horban.study;

import java.util.HashSet;
import java.util.Set;

public class HasUniqueChairs {

    public static boolean hasUniqueChars(String string) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            if (!characters.add(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            true
            false

        */

    }
}
