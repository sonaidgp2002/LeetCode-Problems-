class Solution {
    public int climbStairs(int n) {
        if(n == 0)
            return 0;
        else if( n ==1 )
            return 1;
        else if(n==2)
            return 2;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for( int i=3; i<=n;i++)
        {
            if( i== n)
                return dp[0] + dp[1];
            else
            {
                int temp = dp[0];
                dp[0] = dp[1];
                dp[1] += temp;
            }
        }
        return 0;
    }
}