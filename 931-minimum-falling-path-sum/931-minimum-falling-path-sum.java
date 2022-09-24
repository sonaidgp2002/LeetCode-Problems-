class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
                dp[i][j] = -1;
        }
        for(int i=0;i<matrix[0].length;i++)
        {
            min = Math.min(min, count(matrix, matrix.length-1, i, dp));
        }
        return min;
    }
    public int count(int[][] matrix, int i, int j, int dp[][])
    {
        if(j<0 || j>=matrix[0].length)
            return (int)1e8;
        if(i==0)
        {
            return matrix[i][j];
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        int up = matrix[i][j] + count(matrix, i-1, j, dp);
        int left = matrix[i][j] + count(matrix, i-1, j-1, dp);
        int right = matrix[i][j] + count(matrix, i-1, j+1, dp);
        return dp[i][j] = Math.min(left, Math.min(up, right));
    }
}