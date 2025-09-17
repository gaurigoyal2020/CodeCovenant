class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}


/* Using a HashSet will take O(n) and doing this through sorting will take O(nlogn). */
