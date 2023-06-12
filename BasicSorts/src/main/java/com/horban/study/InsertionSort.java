package com.horban.study;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = ArrayHelper.generateArray(1000);
        int[] array2 = ArrayHelper.generateArray(1000);

        insertionSort(array);
        insertionSortWithBinarySearch(array2);

        System.out.println(ArrayHelper.isSorted(array));
        System.out.println(Arrays.toString(array));
        System.out.println();
        System.out.println(ArrayHelper.isSorted(array2));
        System.out.println(Arrays.toString(array2));

    }

    private static void insertionSortWithBinarySearch(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int index = Math.abs(Arrays.binarySearch(array, 0, i, element) + 1);
            System.arraycopy(array, index, array, index + 1, i - index);
            array[index] = element;
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = i;
            while (index >= 1 && array[index] < array[index - 1]) {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }
}
