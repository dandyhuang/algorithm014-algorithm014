class Solution {
    public String removeOuterParentheses(String S) {
        int num = 0;
        StringBuffer sb = new StringBuffer();
        for (char c : S.toCharArray()) {
            if (c == ')') {
                num--;
            }
            if (num > 0) {
                sb.append(c);
            }
            if (c == '(') {
                num++;
            }
        }
        return sb.toString();
    }
}