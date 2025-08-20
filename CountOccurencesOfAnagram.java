/*
 * anagram -two words jumbled same like silent and listem are anagrams
 */
class CountOccurencesOfAnagram {
    public int countAnagrams(String s, String p) {
        int n = p.length();
        int m = s.length();

        int[] arr = new int[26];
        int[] check = new int;

        for (int i = 0; i < n; i++) {
            arr[p.charAt(i) - 'a']++;
        }

        int count = 0;

        // Initialize the first window (0 to n-2)
        for (int i = 0; i < n - 1; i++) {
            check[s.charAt(i) - 'a']++;
        }

        // Slide over s with window size n
        for (int i = n - 1, j = 0; i < m; i++, j++) {
            check[s.charAt(i) - 'a']++;

            boolean match = true;
            for (int k = 0; k < 26; k++) {
                if (arr[k] != check[k]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }

            check[s.charAt(j) - 'a']--;
        }

        return count;
    }
    public static int countAnagrams2(String txt, String pat) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pat.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int count = map.size();
        int i = 0, j = 0, k = pat.length();
        int ans = 0;

        while (j < txt.length()) {
            char c = txt.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }

            if (j - i + 1 < k) j++;
            else if (j - i + 1 == k) {
                if (count == 0) ans++;

                char left = txt.charAt(i);
                if (map.containsKey(left)) {
                    if (map.get(left) == 0) count++;
                    map.put(left, map.get(left) + 1);
                }
                i++; j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAnagrams2("forxxorfxdofr", "for"));
    }

}
