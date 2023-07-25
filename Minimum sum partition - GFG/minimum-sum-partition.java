//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    for(int i=0;i<n;i++)
	        sum += arr[i];
	    boolean[][] dp = new boolean[n][sum+1];
        for(int i=0;i<n;i++)
            dp[i][0] = true;
        if(arr[0] <= sum)
            dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int j = 0;j<=sum;j++){
                boolean take = false;
                if(arr[i] <= j)
                    take = dp[i-1][j - arr[i]];
                boolean nottake = dp[i-1][j];
                dp[i][j] = take | nottake;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[n-1][i] == true)
                min = Math.min(min, Math.abs((sum - i) - i));
        }
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
	} 
}
