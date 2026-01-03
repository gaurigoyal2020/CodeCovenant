class Solution {
    public int repeatedNTimes(int[] nums) {
        if(nums.length==4){
                if(nums[0]==nums[3])
                    return nums[0];
            } //edge case : [9, 4, 5, 9] -> 
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1] || nums[i] == nums[i+2] )
                return nums[i];
        }
        return 0;
    }
}
