class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return count(grid, m-1, n-1, dp);
    }
    public int count(int[][] grid, int i, int j, int[][] dp)
    {
        if(i==0 && j==0)
        {
            return grid[i][j];
        }
        if(i<0 || j<0)
        {
            return -1;
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        int left = count(grid, i, j-1, dp);
        int up = count(grid, i-1, j, dp);
        if(left!=-1) left += grid[i][j];
        if(up!=-1) up += grid[i][j];
        if(left == -1)
            return dp[i][j] = up;
        if(up == -1)
            return dp[i][j] = left;
        int x = Math.min(up, left);
        return dp[i][j] = (x);
    }
}