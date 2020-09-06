class Solution {
    public boolean isNumber(String s) {
        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numSeen = true;
            } else if (c == '.') {
                //.之前不允许出现.和e    数字e后面必须跟整数
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == '-' || c == '+') {
                //-+只有出现在e/E的后面或者出现在首位才是正常的
                if (i != 0 && s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                //e/E前只能出现在数字后，且e前面不允许出现e
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else {
                return false;
            }
        }
        return numSeen;
    }
}