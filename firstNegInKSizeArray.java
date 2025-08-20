public class FirstNegativeInWindow {
    public void firstnegWin(int [] nums,int k){
        List<Integer> ans= new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(arr[i]<0) q.add(arr[i]);
        }
        // Add answer for the first window
        ans.add(q.isEmpty() ? 0 : q.peek());

        // Slide the window from index k to n-1
        for(int j=k;j<n;j++){
            // Remove the element exiting the window
            if (!q.isEmpty() && arr[j - k] == q.peek()) {
                q.poll();
            }
            // Add the new element
            if(arr[i]<0) q.add(arr[j]);
             // Add the first negative number or 0 for the current window
            ans.add(q.isEmpty() ? 0 : q.peek());
        }
        for(int num : ans) {
            System.out.print(num + " ");
        }
    }
    
    
    public static List<Integer> firstNegative(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        int n = arr.length;
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) dq.add(arr[j]);

            if (j - i + 1 == k) {
                if (!dq.isEmpty()) ans.add(dq.peek());
                else ans.add(0);

                if (arr[i] < 0) dq.poll();
                i++;
            }
        }
        return ans;
    }
}

/*
 * 

    The first for loop fully processes the initial window [0 ... k-1].

    Then we add the first answer for this initial window.

    The second for loop slides the window from k onward, removing the element that goes out and adding the new one.

    Each time, it records the first negative integer or 0 if none.

This way, the initial window is processed completely with the window size k in one go.
 */