class Solution {
    int count = 0;

    public int countSubstrings(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            getLongestPlalindrome(s, i, i);
            getLongestPlalindrome(s, i, i + 1);
        }
        return count;
    }

    private void getLongestPlalindrome(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}