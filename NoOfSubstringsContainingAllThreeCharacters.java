/*
 * Number of Substrings Containing All Three Characters (LeetCode 1358, Medium)

👉 Problem: Count substrings that contain at least one 'a', 'b', and 'c'.
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1};
        int result = 0;

        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                result += (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }
        return result;
    }
}
/*
 * Explanation

Keep track of last index where each character 'a', 'b', 'c' was seen.

Once all three seen, every substring ending at current index and starting before min(lastSeen) is valid.
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int [] count = new int[3];
        int left =0;
        int result  =0;
        for(int i=0; i< s.length();i++){
            count[s.charAt(i)-'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                result += s.length()-i;
                count[s.charAt(left)-'a']--;
                left++; 
            }
        }
        return result;
    }
}