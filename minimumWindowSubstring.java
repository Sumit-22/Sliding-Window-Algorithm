/*
 * 11. Minimum Window Substring (LeetCode 76, Hard)

👉 Problem: Find smallest substring of s containing all characters of t.
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        Map<Character, Integer> window = new HashMap<>();
        int have = 0, needCount = need.size();
        int left = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }
            
            while (have == needCount) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char lChar = s.charAt(left);
                window.put(lChar, window.get(lChar) - 1);
                if (need.containsKey(lChar) && window.get(lChar) < need.get(lChar)) {
                    have--;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
/*Explanation

Two hashmaps: one for required chars, one for window.

Expand right pointer until window valid.

Shrink left pointer to minimize length.

Track smallest valid substring. */