class Solution {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int sum = 0;
        int last = 0;
        int idx = 0;

        while(idx < len) {
            int num = 1;
            char c = s.charAt(idx);
            while(++idx < len && s.charAt(idx) == c){
                num++;
            }
            sum = sum + Math.min(num, last);
            last = num;
        }
        return sum;
    }
}