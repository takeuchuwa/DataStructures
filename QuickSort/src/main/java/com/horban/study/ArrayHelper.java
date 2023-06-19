package com.horban.study;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayHelper {
    public static int[] generateArray(int length) {
        return ThreadLocalRandom.current().ints(length, 1, 100000).toArray();
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
