class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // if(amount == 0)
        //     return 0;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
                dp[i][j] = -1;
        }
        int x = coin(coins, amount, n-1, dp);
        if(x >= 1e8)
            return -1;
        return x;
    }
    public int coin(int[] coins, int amount, int n, int[][] dp)
    {
        // if(amount < 0 || n <0 )
        //     return (int)1e9;
        // if(amount % coins[n] == 0)
        //     return amount / coins[n];
        if(n == 0)
        {
            if(amount % coins[n] == 0)
                return amount / coins[n];
            return (int)1e8;
        }
        if(dp[n][amount] != -1)
            return dp[n][amount];
        int notpick = 0 + coin(coins, amount, n-1, dp);
        int pick = (int)1e8;
        if(coins[n] <= amount)
        {
            // if((amount - coins[n]) <= amount)
                pick = 1 + coin(coins, amount - coins[n], n, dp);
            // else
            //     pick = 1 + coin(coins, n-1, amount - coins[n]);
        }
        return dp[n][amount] = Math.min(pick , notpick);
    }
}