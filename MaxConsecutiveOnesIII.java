//Max Consecutive Ones III (LeetCode 1004, Medium)

//👉 Problem: Given a binary array nums and integer k, return the maximum number of consecutive 1’s if you can flip at most k zeros.

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            
            // Shrink window until <= k zeros
            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
