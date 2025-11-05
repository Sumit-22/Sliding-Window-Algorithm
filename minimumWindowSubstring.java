/*
 * 11. Minimum Window Substring (LeetCode 76, Hard)

👉 Problem: Find smallest substring of s containing all characters of t.
 */
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> mp = new HashMap<>();
        for (char c : t.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        int needCount = t.length(); // total chars we need to match
        int left = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // decrease frequency if present in map
            if (mp.containsKey(ch)) {
                if (mp.get(ch) > 0) needCount--;
                mp.put(ch, mp.get(ch) - 1);
            }

            // when all characters are matched
            while (needCount == 0) {
                // update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (mp.containsKey(leftChar)) {
                    mp.put(leftChar, mp.get(leftChar) + 1);
                    if (mp.get(leftChar) > 0) needCount++;
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