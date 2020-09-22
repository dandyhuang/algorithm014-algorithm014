class Solution {
    public int maxProfit(int[] prices) {

        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        //第几天 第几次 有无股票
        int firstBuy = -prices[0];
        int firstSell = 0;
        int secondBuy = -prices[0];
        int secondSell = 0;
        for(int i = 1; i < len; i++) {
           firstBuy = Math.max(firstBuy, - prices[i]);
           firstSell = Math.max(firstSell, firstBuy + prices[i]);
           secondBuy = Math.max(secondBuy, firstSell - prices[i]);
           secondSell = Math.max(secondSell, secondBuy + prices[i]);
        }
        return secondSell;
    }
}