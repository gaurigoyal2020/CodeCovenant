class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        for(int i=1; i<points.length; i++){
            ans+= Math.max(Math.abs(points[i][0] - points[i-1][0]), Math.abs(points[i][1] - points[i-1][1]));
        }
        return ans;
    }
}

// In 1 second, we can move diagonally (x±1, y±1).
// So we keep moving diagonally until one coordinate matches.
// After that, only horizontal/vertical moves remain.
// Total seconds needed = max(dx, dy).
