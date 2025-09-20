class BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length, idx = -1;
        int l=0, h=n-1;
        while(l<=h) {
            idx = (l+h)/2;
            if(nums[idx] == target)
                return idx;
            else if(nums[idx] < target)
                l = idx+1;
            else
                h = idx-1;
        }
        return -1;
    }
}
