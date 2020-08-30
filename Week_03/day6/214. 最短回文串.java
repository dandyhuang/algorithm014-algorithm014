class Solution {
    public String shortestPalindrome(String s) {

        int len = s.length();
        int idx = (len - 1) / 2;
        StringBuffer sb = new StringBuffer();
        while (idx >= 0) {
            int len1 = missPalindromeLen(s, idx, idx);
            int len2 = missPalindromeLen(s, idx, idx + 1);
            if (len1 == -1 && len2 == -1) {
                idx--;
            } else {
                int missNum = Math.min(len1 < 0 ? Integer.MAX_VALUE : len1, len2 < 0 ? Integer.MAX_VALUE : len2);
                int pos = len - 1;
                while (missNum-- > 0) {
                    sb.append(s.charAt(pos--));
                }
                sb.append(s);
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private int missPalindromeLen(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (left >= 0) {
            return -1;
        } else {
            return s.length() - right;
        }
    }
}