//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int n) {
        // code here
        int o = n;
        int c = n;
        int m = 0;
        ArrayList<String> str = new ArrayList<>();
        check("", str, n, o, c, m);
        return (str);
    }
    static void check(String s, List<String> str,int n, int o, int c, int m)
    {
        if(n == m)
        {
            str.add(s);
            return;
        }
        if(o == c) {
            s += "1";
            o += 1;
            check(s, str, n, o, c, m+1);
            o -= 1;
        }
        else if(o>c){
            String s2 = s;
            s += "1";
            o += 1;
            check(s, str, n, o, c, m+1);
            o -= 1;
            s2 += "0";
            c += 1;
            check(s2, str, n, o, c, m+1);
            c -= 1;
        }
    }
}