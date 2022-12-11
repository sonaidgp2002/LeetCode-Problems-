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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s)
    {
        //code here
        String t = "";
        int m = s.length();
        for(int i=m-1;i>=0;i--)
        {
            t += String.valueOf(s.charAt(i));
        }
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        int i=0, j=0;
        for(i=1;i<m+1;i++)
        {
            for(j=1;j<n+1;j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return(dp[m][n]);
    }
}