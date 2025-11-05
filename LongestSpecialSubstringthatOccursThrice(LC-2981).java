/*
LC 2981 – Find Longest Special Substring That Occurs Thrice I
*/
// Brute Force - Check all substrings

import java.util.Map;

public int longestSpecialSubstringBrute(String s){
    int n = s.length(),maxi = 0;
    for(int len =1;len<=n; len++){
        Map<String,Integer> mp = new HashMap<>();
        for(int i=0;i<=n-len;i++){
            String sub = s.substring(i,i+len);  //how to generate all substring
            mp.put(sub,mp.getOrDefault(sub,0)+1);
            if(mp.get(sub)>= 3) maxi = Math.max(maxi,len);
        }
    }
    return maxi;
}
// Better - HashMap + Rolling Hash
// Sketch: store substring hashes instead of strings, count occurrences

// Optimal - Binary Search + Rolling Hash
public int longestSpecialSubstringOptimal(String s) {
    int left = 1, right = s.length(), ans = 0;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (existsSubstringOccurringThrice(s, mid)) {
            ans = mid;
            left = mid + 1;
        } else right = mid - 1;
    }
    return ans;
}

private boolean existsSubstringOccurringThrice(String s, int len) {
    Map<Long, Integer> map = new HashMap<>();
    long hash = 0, base = 26, mod = 1_000_000_007, pow = 1;
    for (int i = 0; i < len; i++) pow = (pow * base) % mod;
    for (int i = 0; i < s.length(); i++) {
        hash = (hash * base + (s.charAt(i) - 'a')) % mod;
        if (i >= len - 1) {
            if (i >= len) hash = (hash - (s.charAt(i - len) - 'a') * pow % mod + mod) % mod;
            map.put(hash, map.getOrDefault(hash, 0) + 1);
            if (map.get(hash) >= 3) return true;
        }
    }
    return false;
}