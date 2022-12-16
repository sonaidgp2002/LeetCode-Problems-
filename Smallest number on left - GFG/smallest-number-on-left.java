//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        //code here
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(stk.size() == 0)
            nums.add(-1);
            else if(stk.size()>0 && stk.peek()<arr[i])
            {
                nums.add(stk.peek());
            }
            else if(stk.size()>0 && stk.peek()>=arr[i])
            {
                while(stk.size()>0 && stk.peek()>=arr[i])
                stk.pop();
                if(stk.size() == 0)
                nums.add(-1);
                else
                nums.add(stk.peek());
            }
            stk.push(arr[i]);
        }
        return nums;
        // int res[] = new int[nums.size()];
        // for(int i=0;i<nums.size();i++)
        // res[i] = nums.get(i);
        // return res;
    }
}