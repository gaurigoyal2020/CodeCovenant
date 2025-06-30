public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if(alphabet[t.charAt(i) - 'a'] <= -1)
                return false;
        }
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}

//For 'a': 'a' - 'a' equals 0.
//For 'b': 'b' - 'a' equals 1.
//For 'z': 'z' - 'a' equals 25.
//This helps map each letter in the alphabet (a-z) to a specific index of the alphabet array.
