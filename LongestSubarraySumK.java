//sum k + unique k + no repeating character (3)
class LongestSubarraySumK {
    public static int longestSubarray(int[] arr, int k) {
        int i = 0, sum = 0, maxLen = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            while (sum > k) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
//Longest Substring with K Unique Characters
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
//Longest Substring Without Repeating Characters
class LongestSubstringNoRepeat {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.get(s.charAt(j)) > 1) {
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

