class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = leftSearch(nums, target);
        int last = rightSearch(nums, target);
        return new int[] {first, last};
    }

    private int leftSearch(int[] nums, int target) {
        int low = 0, high = nums.length-1, ans =-1;
        while(low<=high) {
            int mid =  low + (high - low) / 2;

            if(target <= nums[mid]) {
                high = mid-1; //move left
            }
            else
                low = mid+1;
            
            if(target == nums[mid])
                ans = mid;
        }
        return ans;
    }

    private int rightSearch(int[] nums, int target) {
        int low=0, high=nums.length-1, ans = -1;
        while(low<=high) {
            int mid = low + (high - low) /2;
            if(target >= nums[mid]) //move right
                low = mid+1;
            else
                high = mid-1;

            if(nums[mid] == target)
                ans = mid;
        }
        return ans;
    }
}

//The KEY here is the >"="/ <"=".
//This Forcefully makes the BS still search left/right even after finding the first target occurance
//And we keep saving best pasuible value in ans
