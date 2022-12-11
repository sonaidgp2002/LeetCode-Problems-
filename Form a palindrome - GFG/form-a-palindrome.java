//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
        String str1 = "";
        int m = str.length();
        for(int i=str.length()-1;i>=0;i--)
        {
            str1 += String.valueOf(str.charAt(i));
        }
        int dp[][] = new int[m+1][m+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(str.charAt(i-1) == str1.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return m-dp[m][m];
    }
}