package com.horban.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SubArraySum {

    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (Map.Entry<Integer, Integer> diffIndexEntry : hashMap.entrySet()) {
                hashMap.put(diffIndexEntry.getKey(), diffIndexEntry.getValue() - nums[i]);
            }
            hashMap.put(i, target - nums[i]);
            Optional<Integer> startIndex = hashMap.entrySet().stream().filter(entry -> entry.getValue() == 0).map(Map.Entry::getKey).findFirst();
            if (startIndex.isPresent()) {
                return new int[]{startIndex.get(), i};
            }
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println(Arrays.toString(result1));

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println(Arrays.toString(result2));

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println(Arrays.toString(result3));

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println(Arrays.toString(result4));

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */

    }
}
