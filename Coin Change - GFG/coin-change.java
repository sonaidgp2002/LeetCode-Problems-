//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][] = new long[N+1][sum+1];
        for(int i=0;i<N+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0 && j==0)
                dp[i][j] = 1;
                else if(j==0)
                dp[i][j] = 1;
            }
        }
        for(int i=1;i<N+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                long take=0, nottake=0;
                if(coins[i-1]<=j)
                {
                    take = dp[i][j-coins[i-1]];
                }
                nottake = dp[i-1][j];
                dp[i][j] = take + nottake;
            }
        }
        return dp[N][sum];
    }
}