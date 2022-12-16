//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().immediateSmaller(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void immediateSmaller(int arr[], int n) {
        // code 
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            if(stk.size() == 0)
            nums.add(-1);
            else if(stk.size()>0 && stk.peek()<arr[i])
            {
                if(stk.peek()==arr[i+1] && i<=n-2)
                nums.add(stk.peek());
            }
            else if(stk.size()>0 && stk.peek()>=arr[i])
            {
                while(stk.size()>0 && stk.peek()>=arr[i])
                stk.pop();
                if(stk.size() == 0 )
                nums.add(-1);
                else
                {
                    if(stk.peek()==arr[i+1] && i<=n-2)
                    nums.add(stk.peek());
                    else
                    nums.add(-1);
                }
            }
            stk.push(arr[i]);
        }
        int j = 0;
        for(int i=nums.size()-1;i>=0;i--)
        arr[j++] = nums.get(i);
    }
}