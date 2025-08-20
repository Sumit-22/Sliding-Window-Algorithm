
public class MaxSumSubarray {
    public int maxsumSubarray(int [] nums,int k){
        int j=0,sum=0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        ans = sum;
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}