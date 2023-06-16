package com.horban.study;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Instant start = Instant.now();
        int[] array = ArrayHelper.generateArray(1000000);

        array = mergeSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println(ArrayHelper.isSorted(array));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration);
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));


        return merge(left, right);
    }

    public static int[] merge(int[] sortedArray1, int[] sortedArray2) {
        int[] combined = new int[sortedArray1.length + sortedArray2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < sortedArray1.length && j < sortedArray2.length) {
            if (sortedArray1[i] < sortedArray2[j]) {
                combined[index] = sortedArray1[i];
                i++;
            } else {
                combined[index] = sortedArray2[j];
                j++;
            }
            index++;
        }
        while (i < sortedArray1.length) {
            combined[index] = sortedArray1[i];
            index++;
            i++;
        }
        while (j < sortedArray2.length) {
            combined[index] = sortedArray2[j];
            index++;
            j++;
        }

        return combined;
    }
}