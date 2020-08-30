class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int n3 = 0;
        int n5 = 0;
        int n7 = 0;
        for (int i = 1; i < k; i++) {
            int val = Math.min(Math.min(dp[n3] * 3, dp[n5] * 5), dp[n7] * 7);
            dp[i] = val;
            if (dp[n3] * 3 == val) {
                n3++;
            }
            if (dp[n5] * 5 == val) {
                n5++;
            }
            if (dp[n7] * 7 == val) {
                n7++;
            }
        }
        return dp[k - 1];
    }
}