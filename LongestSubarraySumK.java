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
