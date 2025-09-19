class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            ans[i] = 1;
        }
        int left = 1, right = 1;
        for(int j=0; j<nums.length; j++) {
            ans[j] *= left;
            left *= nums[j];
        }
        for(int k=nums.length-1; k>=0; k--) {
            ans[k] *= right;
            right *= nums[k];
        }
        return ans;
    }
}
