//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[n][w+1];
        for(int i=0;i<=w;i++){
            dp[0][i] = ((int)(i/wt[0]))*val[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                int take = 0;
                if(wt[i] <= j)
                    take = val[i] + dp[i][j - wt[i]];
                int nottake = dp[i-1][j];
                dp[i][j] = Math.max(take, nottake);
            }
        }
        return(dp[n-1][w]);
    }
}