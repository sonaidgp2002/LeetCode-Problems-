class Solution {
    public int uniquePaths(int m, int n) {
        // int dp[][] = new int[m][n];
        // for(int i=0;i<m; i++)
        // {
        //     for(int j=0;j<n;j++)
        //         dp[i][j]=0;
        // }
        // for(int i=0;i<m;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         if(i==0 && j==0)
        //             dp[i][j]=1;
        //         else
        //         {
        //             int left =0, up=0;
        //             if(i>0) up=dp[i-1][j];
        //             if(j>0) left=dp[i][j-1];
        //             dp[i][j]=(up+left);
        //         }
        //     }
        // }
        // // return count(m-1, n-1, dp);
        // return dp[m-1][n-1];
        int dp[] = new int[n];
        for(int i=0;i<n;i++)
            dp[i]=0;
        for(int i=0;i<m;i++)
        {
            int temp[] = new int[n];
            for(int j=0;j<n;j++)
            {
                if(j==0)
                    temp[j]=1;
                else if(j>0)
                {
                    temp[j] = dp[j] + temp[j-1];
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
    // public int count(int i, int j, int dp[][])
    // {
    //     if(i==0 && j==0)
    //         return 1;
    //     if(i<0 || j<0)
    //         return 0;
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
    //     int left = count(i, j-1, dp);
    //     int up = count(i-1, j, dp);
    //     return dp[i][j] = (left + up);
    // }
}