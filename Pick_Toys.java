//Pick Toys (same as Longest Substring with 2 Unique)

import java.util.*;

class PickToys {
    public static int pickToys(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() > 2) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) map.remove(left);
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
