class Solution {
    public int maxProfit(int k, int[] prices) {

        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        if(k > len/2) {
            return maxProfit(prices);
        }
        int[][] dp = new int[k + 1][2];
        for(int i = 1; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i = 1; i < len; i++) {
            for(int j = 1; j <= k; j++){
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                sum = sum + prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}