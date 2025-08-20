//Longest Substring with K Unique Characters

import java.util.*;

class LongestSubstringKUnique {
    public static int longestKUnique(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() > k) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) map.remove(left);
                i++;
            }
            if (map.size() == k) maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
