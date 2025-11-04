/*
 * Problem Description

You need to implement a class that calculates the moving average of a stream of integers within a sliding window of a fixed size.

The MovingAverage class should support two operations:

    Constructor MovingAverage(int size): Initializes the object with a window size. This window will hold at most size recent values from the stream.

    Method next(int val): Adds a new integer val to the stream and returns the average of the most recent values in the window. If the total number of values seen so far is less than the window size, it returns the average of all values seen so far.

For example, if the window size is 3:

    After adding the first value, the average is just that value
    After adding the second value, the average is of those two values
    After adding the third value, the average is of all three values
    After adding the fourth value, the window slides - it drops the first value and keeps only the most recent three values, then calculates their average

 */

 /*
  * brute force : store all values
  */

  class MovingAverageBrute {
    private int size;
    private List<Integer> list;

    public MovingAverageBrute(int size) {
        this.size = size;
        this.list = new ArrayList<>();
    }

    public double next(int val) {
        list.add(val);
        int start = Math.max(0, list.size() - size);
        double sum = 0;
        for (int i = start; i < list.size(); i++) sum += list.get(i);
        return sum / Math.min(size, list.size());
    }
    //O(k) per query. Simple but not optimal.
}
/*
 * 
 * better (queue + sum variable)
 * 
 */
class MovingAverageBetter {
    private Queue<Integer> queue;
    private int size;
    private double sum;

    public MovingAverageBetter(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > size) sum -= queue.poll();
        return sum / queue.size();
    }
}
