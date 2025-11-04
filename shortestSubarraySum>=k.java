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
/// so “Simple Sliding Window” Works Only for Non-Negative Arrays
///  Basic Idea (for positives only)
 /* 
We maintain a window [left, right] and a running sum:
sum += nums[right];

while (sum >= K) {
    ans = Math.min(ans, right - left + 1);
    sum -= nums[left++];
}
This works because:

✅ When all numbers are non-negative, increasing right always increases sum.
✅ Moving left forward always decreases sum.

That means the sum changes monotonically as the window expands or shrinks, letting us adjust the window deterministically.

🚫 Why It Fails with Negatives

If nums has negative values, this monotonic behavior breaks.

Let’s see an example:
nums = [2, -1, 2]
K = 3
Try the normal sliding window:
Step	Window	Sum	Action
[0]	[2]	2	< K
[0,1]	[2, -1]	1	< K
[0,2]	[2, -1, 2]	3	✅ ≥ K (len=3)
Move left	[1,2]	1	< K ❌*/