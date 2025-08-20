class LongestSubarraySumK {
    public static int longestSubarray(int[] arr, int k) {
        int i = 0, j = 0, sum = 0, maxLen = 0;

        while (j < arr.length) {
            sum += arr[j];

            while (sum > k) {
                sum -= arr[i];
                i++;
            }

            if (sum == k) maxLen = Math.max(maxLen, j - i + 1);

            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,1,1,2,3,5};
        System.out.println(longestSubarray(arr, 5));
    }
}
