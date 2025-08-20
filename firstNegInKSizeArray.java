public class FirstNegativeInWindow {
    public int firstnegWin(int [] nums,int k){
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
}