//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
        //long arr[] = new long[N-1];
        ArrayList<Long> arr = new ArrayList<>();
        Queue<Long> q = new LinkedList<>();
        int i = 0;
        int j = 0;
        int m = 0;
        while(j<A.length)
        {
            if(A[j] < 0)
            q.add(A[j]);
            if(j-i+1 < k)
            j++;
            else if(j-i+1 == k)
            { 
                if(!q.isEmpty())
                arr.add(q.peek());
                else
                arr.add((long)0);
                if(!q.isEmpty() && q.peek() == A[i])
                q.poll();
                i++;
                j++;
            }
        }
        long res[] = new long[arr.size()];
        for(i=0;i<arr.size();i++)
        {
            res[i] = arr.get(i);
        }
        return res;
    }
}