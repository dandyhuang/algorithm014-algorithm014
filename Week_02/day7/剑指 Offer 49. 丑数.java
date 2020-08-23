class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        int k = 2;
        while (k <= n) {
            int p2Val = dp[p2] * 2;
            int p3Val = dp[p3] * 3;
            int p5Val = dp[p5] * 5;
            int minVal = Math.min(Math.min(p2Val, p3Val), p5Val);
            dp[k++] = minVal;
            if (minVal == p2Val) {
                p2++;
            }
            if (minVal == p3Val) {
                p3++;
            }
            if (minVal == p5Val) {
                p5++;
            }
        }
        return dp[n];
    }
}