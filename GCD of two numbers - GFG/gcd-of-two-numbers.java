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
                    int A = sc.nextInt();
                    int B = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.gcd(A,B));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int gcd(int a , int b) 
    { 
        //code here
        while(a > 0 && b > 0){
            if(a > b)
                a %= b;
            else
                b %= a;
        }
        if(a == 0)
            return b;
        return a;
    } 
}