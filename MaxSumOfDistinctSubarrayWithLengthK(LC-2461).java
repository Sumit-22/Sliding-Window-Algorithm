
// 2461. Maximum Sum of Distinct Subarrays With Length K

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum =0;
        long mx =0;
        int left =0;
        HashSet<Integer> set = new HashSet();
        for(int right = 0; right< nums.length; right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum-=nums[left];
                left++;  //it ensures no duplicate element is present in the window
            }
            set.add(nums[right]);
            sum+=nums[right];
            if(set.size()==k){
                mx = Math.max(mx,sum);
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }

        }
        return mx;
    }
}