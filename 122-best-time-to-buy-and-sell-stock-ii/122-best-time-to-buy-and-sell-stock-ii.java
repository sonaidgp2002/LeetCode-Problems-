class Solution {
    public int maxProfit(int[] prices) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i]>prices[i+1])
                continue;
            else
                sum+=prices[i+1]-prices[i];
        }
        return sum;
    }
}