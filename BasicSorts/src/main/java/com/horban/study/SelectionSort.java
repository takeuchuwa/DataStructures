package com.horban.study;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = ArrayHelper.generateArray(1000);

        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        System.out.println(ArrayHelper.isSorted(array));
        System.out.println(Arrays.toString(array));
    }
}
