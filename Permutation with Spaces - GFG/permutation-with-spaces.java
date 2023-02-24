//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String s){
        // Code Here
        ArrayList<String> str1 = new ArrayList<>();
        check(0, s, "", str1);
        Collections.sort(str1);
        return str1;
    }
    static void check(int n,String str, String s1, List<String> str1)
    {
        if(n == str.length()) {
            if(!str1.contains(s1))
                str1.add(s1);
                return;
        }
        s1 += String.valueOf(str.charAt(n));
        String s2 = s1;
        if(n!=str.length()-1)
        s2 += " ";
        check(n+1, str, s1, str1);
        check(n+1, str, s2, str1);
    }
}