//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        // Stack<Long> stk= new Stack<>();  
        // ArrayList<Long> nums = new ArrayList<>();
        // for(int i=n-1;i>=0;i--)
        // {
        //     if(stk.size() == 0)
        //     {
        //         nums.add( (long)-1);
        //     }
        //     else if((stk.size() > 0) && (stk.peek()>arr[i]))
        //     {
        //         nums.add(stk.peek());
        //     }
        //     else if((stk.size() > 0) && (stk.peek()<=arr[i]))
        //     {
        //         while(stk.size()>0 && (stk.peek()<=arr[i]))
        //         stk.pop();
        //         if(stk.size() == 0)
        //         nums.add( (long)-1);
        //         else
        //         nums.add(stk.peek());
        //     }
        //     stk.push( arr[i] );
        // }
        // long ans[] = new long[nums.size()];
        // int j = 0;
        // for(int i=nums.size()-1;i>=0;i--)
        // {
        //     ans[j++] = nums.get(i);
        // }
        // return ans;
        Stack<Long> stk = new Stack<>();
        ArrayList<Long> store = new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            if(stk.size() == 0)
            {
                store.add((long)-1);
            }
            else if(stk.size()>0 && stk.peek()>arr[i])
            {
                store.add(stk.peek());
            }
            else if(stk.size()>0 && stk.peek()<=arr[i])
            {
                while(stk.size()>0 && stk.peek()<=arr[i])
                stk.pop();
                if(stk.size() == 0)
                store.add((long)-1);
                else
                store.add(stk.peek());
            }
            stk.push(arr[i]);
        }
        int j = 0;
        for(int i=store.size()-1;i>=0;i--)
        arr[j++] = store.get(i);
        return arr;
    } 
}