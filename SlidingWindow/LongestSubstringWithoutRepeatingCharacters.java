class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0;
        int maxLength=0;
        HashSet<Character> set = new HashSet<>();

        for( ; right<s.length(); right++) {
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
