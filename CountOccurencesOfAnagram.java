import java.util.*;

class Solution {
    public int countAnagrams(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        if (m > n) return 0;

        int[] patFreq = new int[26];
        int[] winFreq = new int[26];
        int count = 0;

        // Build pattern frequency
        for (char c : pat.toCharArray())
            patFreq[c - 'a']++;

        // First window
        for (int i = 0; i < m; i++)
            winFreq[txt.charAt(i) - 'a']++;

        // Check first window
        if (Arrays.equals(patFreq, winFreq)) count++;

        // Slide the window
        for (int i = m; i < n; i++) {
            // Add new char
            winFreq[txt.charAt(i) - 'a']++;
            // Remove old char
            winFreq[txt.charAt(i - m) - 'a']--;
            // Compare
            if (Arrays.equals(patFreq, winFreq)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countAnagrams("forxxorfxdofr", "for")); // Output: 3
    }
}
