class Solution {
    public int fib(int N) {
            int q = 0;
            int p = 1;
            int r = 0;
            for(int i = 1; i <= N; i++) {
                r = p;
                p = p + q;
                q = r;
            }
            return r;
    }
}