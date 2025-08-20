/*
 * Maximum Points You Can Obtain from Cards (LeetCode 1423, Medium)

👉 Problem: Pick k cards from either start or end of array to maximize sum.
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        
        // sum of first k cards
        for (int i = 0; i < k; i++) total += cardPoints[i];
        
        int best = total;
        
        // now slide window: remove from left, add from right
        for (int i = 0; i < k; i++) {
            total -= cardPoints[k - 1 - i];
            total += cardPoints[n - 1 - i];
            best = Math.max(best, total);
        }
        
        return best;
    }
}
/*
 * Explanation

Initial take first k from left.

Then gradually replace left cards with right cards.

Keep max sum across all choices.
 */
