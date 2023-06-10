package com.horban.study;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longestConsecutiveSequence = 0;
        for (int num : nums) {
            int tempSequence = 1;
            int tempNumber = num;
            while (numbers.contains(--tempNumber)) {
                tempSequence++;
            }
            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, tempSequence);
        }

        return longestConsecutiveSequence;
    }


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longest = longestConsecutiveSequence(nums);
        System.out.println(longest);

        /*
            Input: int[] nums = [100, 4, 200, 1, 3, 2]

            Output: 4

            Explanation: The longest consecutive sequence in the input array is [4, 3, 2, 1], and its length is 4.

            EXPECTED OUTPUT:
            ----------------
            4

        */

    }
}
