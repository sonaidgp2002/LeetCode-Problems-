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
	    int range=0;
        for(int i=0;i<n;i++)
        {
            range += arr[i];
        }
        Boolean dp[][] = new Boolean[n+1][range+1];
        for(int i=0;i<n+1;i++) {
            for (int j = 0; j < range + 1; j++) {
                dp[i][j] = false;
            }
        }
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<range+1;j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(j==0)
                    dp[i][j] = true;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=0;j<range+1;j++)
            {
                Boolean take1 = false;
                Boolean nottake1 = false;
                if(arr[i-1]<=j)
                {
                    take1 = dp[i-1][j-arr[i-1]];
                }
                nottake1 = dp[i-1][j];
                dp[i][j] = (take1 || nottake1);
            }
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i=0;i<=range/2;i++)
        {
            if(dp[n][i] == true)
            arr1.add(i);
        }
        int min = (int)10e8;
        for(int i=0;i<arr1.size();i++)
        {
            if((range-2*arr1.get(i)) < min)
                min = (range-2*arr1.get(i));
        }
        return min;
	} 
}
