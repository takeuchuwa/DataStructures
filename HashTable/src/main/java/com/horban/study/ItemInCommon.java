package com.horban.study;

public class ItemInCommon {

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashTable<Integer, Boolean> hashMap = new HashTable<>();
        for (int i : array1) {
            hashMap.set(i, true);
        }

        for (int i : array2) {
            if (hashMap.get(i) != null) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};
        int[] array3 = {2, 4, 6};

        System.out.println(itemInCommon(array1, array2));
        System.out.println(itemInCommon(array1, array3));

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false

        */

    }
}
