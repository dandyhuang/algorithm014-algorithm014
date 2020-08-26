class Solution {
    List<String> parenthesisList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtrack(0, 0, n, new StringBuilder());
        return parenthesisList;
    }

    private void backtrack(int left, int right, int n, StringBuilder sb) {

        if (left == n && right == n) {
            parenthesisList.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backtrack(left + 1, right, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < n && left > right) {
            sb.append(")");
            backtrack(left, right + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}