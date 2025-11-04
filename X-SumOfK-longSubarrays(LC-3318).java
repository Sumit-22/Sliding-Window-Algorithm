/**
 * 
 * 3318. Find X-Sum of All K-Long Subarrays I

You are given an array nums of n integers and two integers k and x.The x-sum of an array is calculated by the following procedure:
Count the occurrences of all elements in the array.Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.Calculate the sum of the resulting array.
Note that if an array has less than x distinct elements, its x-sum is the sum of the array.Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the
nums[i..i + k - 1].
 * 
 * 
 * 
 */


class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res= new int[n-k+1];
        for(int i =0;i<res.length;i++){
            res[i] = calculateXSumForSubArray(nums,i,i+k-1,x);
        }
        return res;
    }
    private int calculateXSumForSubArray(int[]nums,int start, int end,int x){
        final int MAX_VALUE =50;
        int [] freq = new int[MAX_VALUE + 1];
        int distinctCnt =0;
        int sum =0;
        for(int i = start;i <=end;i++){
            int num = nums[i];
            sum += num;
            if(freq[num] ==0){
                distinctCnt++;
            }
            freq[num]++;
        }
        if(distinctCnt < x){
            return sum;
        }
        int resSum = 0;
        for(int selection =0;selection <x;selection++){
         int bestNumber = -1;
            int bestFrequency = -1;

            for (int number = MAX_VALUE; number >= 1; number--) {
                if (freq[number] > bestFrequency) {
                    bestFrequency = freq[number];
                    bestNumber = number;
                }
            }

            if (bestNumber != -1) {
                resSum += bestNumber * bestFrequency;
                freq[bestNumber] = 0; 
            }
        }
        
        return resSum;
    }
}