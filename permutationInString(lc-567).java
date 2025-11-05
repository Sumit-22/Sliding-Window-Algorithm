/*
 * LC 567 – Permutation in String

Goal: Check if s1’s permutation exists in s2.

Brute Force: Check all substrings → O(nm26)

Better: Sliding window frequency count → O(n*26)

Optimal: Sliding window with match count → O(n)
 */
public class solution{
 boolean checkInclusionOptimal(String s1, String s2) {
    int[] count = new int[26];
    for (char c : s1.toCharArray()) count[c - 'a']++;

    int left = 0, right = 0, match = s1.length();
    while (right < s2.length()) {
        int idx = s2.charAt(right++) - 'a';
        if (count[idx]-- > 0) match--;
        if (match == 0) return true;
        if (right - left == s1.length() && count[s2.charAt(left++) - 'a']++ >= 0) match++;
  // or 
  /*  if ((right - left) == s1.length()) {
            int leftIdx = s2.charAt(left++) - 'a';
            if (count[leftIdx] >= 0) {
                match++;
            }
            count[leftIdx]++;
        }*/
    }
    return false;
}
}/*
so, basically count array keeps track of how many of each character we still need to form a permutation
match:-counts how many characters are still needed to complete a valid permutation window
when match = 0, we found a permutation
*/
/*
 * Trick:

Same match-count optimization as LC 438.

Sliding window + incremental frequency adjustments is interview favorite.

✅ Summary of Pattern 11:

Approach	Time Complexity	Space Complexity	Notes
Brute Force	O(nm26)	O(26)	Compare all substrings
Better	O(n*26)	O(26)	Sliding window with full frequency array
Optimal	O(n)	O(26)	Sliding window with match count optimization
 */