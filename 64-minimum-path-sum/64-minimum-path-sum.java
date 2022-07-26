class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=0;
            }
        }
        // 
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = grid[i][j];
                else{
                    int left = grid[i][j];
                    int up = grid[i][j];
                    if(j>0) left += dp[i][j-1];
                    else left = Integer.MAX_VALUE;
                    if(i>0) up += dp[i-1][j];
                    else up = Integer.MAX_VALUE;
                    dp[i][j] = Math.min(left, up);
                }
            }
        }
        return dp[m-1][n-1];
    }
    // public int count(int[][] grid, int i, int j, int[][] dp)
    // {
    //     if(i==0 && j==0)
    //     {
    //         return grid[i][j];
    //     }
    //     if(i<0 || j<0)
    //     {
    //         return -1;
    //     }
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
    //     int left = count(grid, i, j-1, dp);
    //     int up = count(grid, i-1, j, dp);
    //     if(left!=-1) left += grid[i][j];
    //     if(up!=-1) up += grid[i][j];
    //     if(left == -1)
    //         return dp[i][j] = up;
    //     if(up == -1)
    //         return dp[i][j] = left;
    //     int x = Math.min(up, left);
    //     return dp[i][j] = (x);
    // }
}