class Solution {
    public int maxProfit(int[] prices) {
        int fix = prices[0];
        int profit = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] > fix){
                profit = Integer.max(profit , prices[i] - fix);
            }
            else{
                fix = prices[i];
            }
        }
        return profit;
    }
}