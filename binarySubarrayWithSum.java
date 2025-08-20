/*
 * Binary Subarray With Sum (LeetCode 930, Medium)

👉 Problem: Given a binary array nums and an integer goal, return the number of subarrays with sum = goal.
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left++];
            }
            count += (right - left + 1);
        }
        return count;
    }
}
/*
 * Explanation

Trick: Count subarrays with sum ≤ goal, and subtract those with sum ≤ goal-1.

Sliding window works because array is binary (non-negative).

Each time we shrink window when sum exceeds goal.
 */