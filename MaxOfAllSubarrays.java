import java.util.*;

class MaxOfAllSubarrays {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]) dq.pollLast();
            dq.offer(j);

            if (j - i + 1 == k) {
                ans.add(nums[dq.peekFirst()]);
                if (dq.peekFirst() == i) dq.pollFirst();
                i++;
            }
        }
        return ans;
    }
}

// or other readable code but with same algo
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>(); // store indices
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            // 1️⃣ Remove elements out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // 2️⃣ Remove smaller elements (they can’t be max anymore)
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.pollLast();

            // 3️⃣ Add current element’s index
            dq.offerLast(i);

            // 4️⃣ Store max once the window is of size k
            if (i >= k - 1)
                res[idx++] = nums[dq.peekFirst()];
        }

        return res;
    }
}

