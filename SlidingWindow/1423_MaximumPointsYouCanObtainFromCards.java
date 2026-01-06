class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        int sum = 0;
        int left = 0;
        int length = cardPoints.length - k;  // Size of middle subarray to leave behind
        int minValue = Integer.MAX_VALUE;

        // Sliding window: find minimum sum of (n-k) consecutive cards in middle
        for(int right = 0; right < cardPoints.length; right++){
            // Shrink window if size exceeds length
            if(right - left + 1 > length) {
                sum -= cardPoints[left];
                left++;
            }
            
            sum += cardPoints[right];        // Current window sum
            totalSum += cardPoints[right];   // Total sum of all cards
            
            // Track minimum when window reaches target size
            if(right - left + 1 == length)
                minValue = Math.min(minValue, sum);
        }
        
        // Max from ends = Total - Min from middle
        return totalSum - minValue;
    }
}
