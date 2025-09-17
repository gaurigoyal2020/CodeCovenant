class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int alphabets[] = new int[26];
        for(int i=0; i<s.length(); i++)
            alphabets[s.charAt(i) - 'a']++;
        for(int j=0; j<t.length(); j++) 
            alphabets[t.charAt(j) - 'a']--;

        for(int n : alphabets) {
            if(n!=0)
                return false;
        }
        return true;
    }
}
