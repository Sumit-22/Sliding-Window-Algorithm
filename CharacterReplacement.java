/*
 * Longest Repeating Character Replacement (LeetCode 424, Medium)

👉 Problem: Find longest substring where you can replace at most k chars to make all same.
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            
            // if more than k replacements needed
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
/*
 * Explanation

Track frequency of most common char in window.

If (window size - maxCount) > k, shrink window.

Max window length is the answer.
 */
