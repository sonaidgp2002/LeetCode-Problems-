//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[] length = new int[n];
        for(int i=0;i<n;i++)
            length[i] = i + 1;
        int sum = n;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                int take = 0;
                int not_take = dp[i-1][j];
                if(length[i-1] <= j)
                    take = price[i-1] + dp[i][j - length[i-1]];
                dp[i][j] = Math.max(take, not_take);
            }
        }
        return(dp[n][sum]);
    }
}