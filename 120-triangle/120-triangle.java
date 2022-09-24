class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j] = -1;
            }
        }
        return count(triangle, n, 0, 0, dp);
    }
    public int count(List<List<Integer>> triangle, int n, int i, int j, int[][] dp)
    {
        if(i==n-1)
        {
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        int down = triangle.get(i).get(j) + count(triangle, n, i+1, j, dp);
        int diagonal = triangle.get(i).get(j) + count(triangle, n, i+1, j+1, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }
}