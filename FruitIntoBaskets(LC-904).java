/*
 * LeetCode 904 – Fruit Into Baskets
 * Goal: Find the longest subarray containing at most 2 distinct integers.
 */

import java.util.*;

class Solution904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

            // Shrink window if >2 distinct fruit types
            while (count.size() > 2) {
                int leftFruit = fruits[left];
                count.put(leftFruit, count.get(leftFruit) - 1);
                if (count.get(leftFruit) == 0) count.remove(leftFruit);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
/*
 * LeetCode 1004 – Max Consecutive Ones III
 * Goal: You can flip at most k zeros to 1. Find the longest subarray with only 1s after flips.
 * 
 */
class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            // If more than k zeros, shrink window
            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
 //Complexity:
 //Time O(n), Space O(1)