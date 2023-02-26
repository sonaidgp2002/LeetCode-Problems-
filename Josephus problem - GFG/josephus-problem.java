//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{
   public int josephus(int n, int k)
    {
        //Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++)
            arr.add(i);
        int x = check(0, k-1, arr);
        return (x);
    }
    static int check(int n, int k, ArrayList<Integer> arr)
    {
        if(arr.size() == 1)
            return arr.get(0);
        int x = n+k;
        if(x>=arr.size())
            x = x%arr.size();
        arr.remove(x);
        return check(x, k, arr);
    }
}

