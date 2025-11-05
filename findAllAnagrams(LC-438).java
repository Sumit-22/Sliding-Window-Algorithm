/*
 * 1️⃣ LC 438 – Find All Anagrams in a String

Goal: Return starting indices of all anagrams of p in s.

Brute Force – Check all substrings
 */
// O(n*m*26) where n = s.length(), m = p.length()
List<Integer> findAnagramsBrute(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int m = p.length(), n = s.length();
    int[] target = new int[26];
    for (char c : p.toCharArray()) target[c - 'a']++;
    
    for (int i = 0; i <= n - m; i++) {
        int[] window = new int[26];
        for (int j = 0; j < m; j++) window[s.charAt(i + j) - 'a']++;
        if (Arrays.equals(window, target)) result.add(i);
    }
    return result;
}

//Better – Sliding Window with Frequency Count
// O(n*26)
List<Integer> findAnagramsBetter(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int n = s.length(), m = p.length();
    if (m > n) return res;

    int[] countP = new int[26];
    for (char c : p.toCharArray()) countP[c - 'a']++;

    int[] window = new int[26];
    for (int i = 0; i < n; i++) {
        window[s.charAt(i) - 'a']++;
        if (i >= m) window[s.charAt(i - m) - 'a']--;
        if (Arrays.equals(window, countP)) res.add(i - m + 1);
    }
    return res;
}

//Optimal – Sliding Window with Match Count

// O(n)
List<Integer> findAnagramsOptimal(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] count = new int[26];
    for (char c : p.toCharArray()) count[c - 'a']++;

    int left = 0, right = 0, match = p.length();
    while (right < s.length()) {
        if (count[s.charAt(right++) - 'a']-- > 0) match--;
        if (match == 0) res.add(left);
        if (right - left == p.length() && count[s.charAt(left++) - 'a']++ >= 0) match++;
    }
    return res;
}
/* reason to use :-
 * can you tell like why count array is not enough so match variable is used
 */
/*
 * Key Trick:

Maintain a running match count instead of comparing full arrays.

Increment/decrement counts as window slides → O(n).
 */