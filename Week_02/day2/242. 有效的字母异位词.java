class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        if(s.equals(t)) {
            return true;
        }
        int[] num = new int[26];
        for (char c : s.toCharArray()) {
            num[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            num[c - 'a']--;
            if (num[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}