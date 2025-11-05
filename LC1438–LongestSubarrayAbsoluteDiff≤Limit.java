/*
 * LC 1438 – Longest Continuous Subarray With Absolute Diff ≤ Limit
Problem: Find longest subarray where max - min ≤ limit.
Brute Force – Check All Subarrays
 */
public int longestSubarrayBrute(int[] nums, int limit) {
    int n = nums.length, maxLen = 0;
    for (int i = 0; i < n; i++) {
        int currMax = nums[i], currMin = nums[i];
        for (int j = i; j < n; j++) {
            currMax = Math.max(currMax, nums[j]);
            currMin = Math.min(currMin, nums[j]);
            if (currMax - currMin <= limit) maxLen = Math.max(maxLen, j - i + 1);
            else break;
        }
    }
    return maxLen;
}
/*
 * Time: O(n²)
Space: O(1)
2nd method:--
Better – Sliding Window + TreeMap
 */
public int longestSubarrayBetter(int[] nums, int limit) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int left = 0, maxLen = 0;
    for (int right = 0; right < nums.length; right++) {
        map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        while (map.lastKey() - map.firstKey() > limit) {
            map.put(nums[left], map.get(nums[left]) - 1);
            if (map.get(nums[left]) == 0) map.remove(nums[left]);
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
/*
Time: O(n log n)
Space: O(n)
 * optimal method :-
 * Time: O(n)
Space: O(n)
 */public int longestSubarrayOptimal(int[] nums, int limit) {
    Deque<Integer> maxQ = new ArrayDeque<>();
    Deque<Integer> minQ = new ArrayDeque<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < nums.length; right++) {
        while (!maxQ.isEmpty() && nums[right] > maxQ.peekLast()) maxQ.pollLast();
        while (!minQ.isEmpty() && nums[right] < minQ.peekLast()) minQ.pollLast();
        maxQ.offerLast(nums[right]);
        minQ.offerLast(nums[right]);

        while (maxQ.peekFirst() - minQ.peekFirst() > limit) {
            if (nums[left] == maxQ.peekFirst()) maxQ.pollFirst();
            if (nums[left] == minQ.peekFirst()) minQ.pollFirst();
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
