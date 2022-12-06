//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        // int dp[][] = new int[n+1][W+1];
        // for(int i=0;i<n+1;i++)
        //     for(int j=0;j<W+1;j++)
        //     dp[i][j] = -1;
        // return check(W, wt, val, n-1, dp);
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<W+1;j++)
            {
                if(i==0)
                dp[i][j] = 0;
                if(j==0)
                dp[i][j] = 0;
            }
        for(int i=1;i<n+1;i++)
            for(int j=1;j<W+1;j++)
            {
                if(wt[i-1]<=j)
                {
                    int take = val[i-1] + dp[i-1][j-wt[i-1]];
                    int nottake = dp[i-1][j];
                    dp[i][j] = Math.max(take, nottake);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        return dp[n][W];
    } 
    // static int check(int W, int wt[], int val[], int n, int dp[][])
    // {
    //     if(W==0)
    //      return 0;
    //      if(n==0)
    //      {
    //          if(wt[n]<=W)
    //          return val[n];
    //          return 0;
    //      }
         
    //      if(n<0)
    //      return 0;
    //      else if(dp[n+1][W]!=-1)
    //      return dp[n+1][W];
    //      else if(wt[n]<=W)
    //      {
    //          int take = val[n] + check(W-wt[n], wt, val, n-1, dp);
    //          int nottake = check(W, wt, val, n-1, dp);
    //          return dp[n+1][W] = Math.max(take, nottake);
    //      }
    //      else
    //      {
    //          return dp[n+1][W] = check(W, wt, val, n-1, dp);
    //      }
    // }
}


