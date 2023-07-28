//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[n][n+1];
        for(int i=0;i<=n;i++)
            dp[0][i] = i * price[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int take = Integer.MIN_VALUE;
                int rodlength = i+1;
                if(rodlength <= j)
                    take = price[i] + dp[i][j - rodlength];
                int nottake = dp[i-1][j];
                dp[i][j] = Math.max(take, nottake);
            }
        }
        return(dp[n-1][n]);
    }
}