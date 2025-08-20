/*
 * Minimum Window Subsequence (LeetCode 727, Hard)

👉 Problem: Find the minimum window in s1 that contains s2 as a subsequence.
 */
class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int minLen = Integer.MAX_VALUE, start = -1;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(0)) continue;
            
            int j = i, k = 0;
            // move forward until subsequence found
            while (j < n && k < m) {
                if (s1.charAt(j) == s2.charAt(k)) k++;
                j++;
            }
            
            if (k == m) { // subsequence found
                int end = j - 1;
                k = m - 1;
                // move backward to minimize window
                while (end >= i) {
                    if (s1.charAt(end) == s2.charAt(k)) {
                        k--;
                        if (k < 0) break;
                    }
                    end--;
                }
                if (j - (end + 1) < minLen) {
                    minLen = j - (end + 1);
                    start = end + 1;
                }
            }
        }
        return start == -1 ? "" : s1.substring(start, start + minLen);
    }
}
/*
 * Explanation

Two pointers scanning s1 to find subsequence s2.

Forward pass → find subsequence.

Backward pass → shrink to minimum window.

Track best window.
 */