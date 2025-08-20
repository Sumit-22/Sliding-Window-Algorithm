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
