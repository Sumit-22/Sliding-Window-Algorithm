/*LeetCode 862 – Shortest Subarray with Sum ≥ K

Goal: Find the length of the shortest subarray with sum ≥ K (can include negatives).
➡ Can’t use normal sliding window (because negatives break monotonicity).
Use prefix sums + deque (monotonic queue).*/

import java.util.*;

class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLen = n + 1;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // maintain increasing prefix sums in deque
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        return minLen == n + 1 ? -1 : minLen;
    }
}
