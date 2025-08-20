/*
 * Count Number of Nice Subarrays (LeetCode 1248, Medium)

👉 Problem: Return the number of subarrays with exactly k odd numbers.
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0, count = 0, odd = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) odd++;
            while (odd > k) {
                if (nums[left] % 2 == 1) odd--;
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
/*
 * Explanation

Same as previous trick.

Convert problem into count subarrays with at most k odds.

Result = atMost(k) − atMost(k−1).
 */