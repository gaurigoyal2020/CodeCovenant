class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                if(nums[i]+nums[left]+nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(nums[left] == nums[left-1] && left<right)
                        left++;
                    while(nums[right] == nums[right+1] && left<right)
                        right--;
                }
                else if(nums[i]+nums[left]+nums[right] < 0)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}
