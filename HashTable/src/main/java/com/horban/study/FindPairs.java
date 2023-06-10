package com.horban.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindPairs {

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        for (int num : arr2) {
            if (!set1.add(target - num)) {
                pairs.add(new int[]{target - num, num});
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */

    }
}
