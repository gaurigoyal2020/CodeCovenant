class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0, len=0;
        int maxLen = Integer.MIN_VALUE;

        for(int r=0; r<nums.length; r++) {
            if(nums[r] == 0)
                k--;
            while(k<0){
                if(nums[l] == 0)
                    k++;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
