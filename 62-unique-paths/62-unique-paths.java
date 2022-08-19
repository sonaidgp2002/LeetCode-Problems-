class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = 1;
                else
                {
                    int down = 0, right = 0;
                    if(i > 0)
                        down = dp[i - 1][j];;
                    if(j > 0)
                        right = dp[i][j - 1];
                    dp[i][j] = down + right;
                }
            }
        }
        return dp[m-1][n-1];
    }
    // public int check(int i, int j, int m, int n, int dp[][])
    // {
    //     if(i==0 || j==0)
    //         return 1;
    //     else if(i<0 || j<0)
    //         return 0;
    //     else if(dp[i][j] != -1)
    //         return dp[i][j];
    //     int lh = check(i-1, j, m, n, dp);
    //     int rh = check(i, j-1, m, n, dp);
    //     return dp[i][j] = lh + rh;
    // }
}