class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostOdd(nums, k) - atMostOdd(nums, k-1);
    }

    private int atMostOdd(int nums[], int k) {
        if(k<0)
            return 0;
        
        int count=0, l=0, odd=0;
        for(int r=0; r<nums.length; r++) {
            if(nums[r]%2 != 0)
                odd++;
            
            while(odd>k){
                if(nums[l]%2 != 0)
                    odd--;
                l++;
            }
            count += r-l+1;
        }
        return count;
    }
}
