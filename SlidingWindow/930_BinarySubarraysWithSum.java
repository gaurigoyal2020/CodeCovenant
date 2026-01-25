class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostSum(nums, goal) - atMostSum(nums, goal-1);
    }

    //“Are we calculating subarrays with sum from 0 to goal / goal-1?”
    // ✅ YES. Exactly that.
    // atMostSum(goal) → counts subarrays with sum ∈ [0, goal]
    // atMostSum(goal - 1) → counts subarrays with sum ∈ [0, goal - 1]
    // Subtracting:
    // [0..goal] − [0..goal−1] = {goal}
    
    private int atMostSum(int[] nums, int goal) {
        int count=0, l=0, sum=0;
        for(int r=0; r<nums.length; r++){
            sum += nums[r];

            while(sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
        }
        return count;
    }
}
