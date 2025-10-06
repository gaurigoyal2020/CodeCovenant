class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = -1, maxCap = 0;
        for(int i : weights) {
            minCap = Math.max(minCap, i);
            maxCap += i;
        }
        int left=minCap, right=maxCap;
        while(left<right) {
            int mid = (left+right)/2; //mid gives the plausible (min) capacity of the ship for the "day"

            //simulate the num of days needed to ship
            int daysNeeded = 1, currentDayWeight = 0;
            for(int weight : weights) {
                if(currentDayWeight + weight > mid) {
                    daysNeeded++;
                    currentDayWeight = 0;
                }
                currentDayWeight += weight;
            }
            if(daysNeeded > days)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
}
