class Solution {
    Map<Character, String[]> letterMap = new HashMap<Character, String[]>() {{
        put('1', new String[0]);
        put('2', new String[]{"a", "b", "c"});
        put('3', new String[]{"d", "e", "f"});
        put('4', new String[]{"g", "h", "i"});
        put('5', new String[]{"j", "k", "l"});
        put('6', new String[]{"m", "n", "o"});
        put('7', new String[]{"p", "q", "r", "s"});
        put('8', new String[]{"t", "u", "v"});
        put('9', new String[]{"w", "x", "y", "z"});

    }};
    List<String> resList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        
        recursion(0, digits, new StringBuffer());
        return resList;
    }

    private void recursion(int idx, String digits, StringBuffer sb) {

        if (idx == digits.length()) {
            if (sb.length() > 0) {
                resList.add(sb.toString());
            }
            return;
        }
        char c = digits.charAt(idx);
        String[] letterStr = letterMap.get(c);
        for (int i = 0; i < letterStr.length; i++) {
            recursion(idx + 1, digits, new StringBuffer(sb).append(letterStr[i]));
        }
    }
}