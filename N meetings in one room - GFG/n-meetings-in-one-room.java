//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int count = 0;
        int end_meet = 0;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int i=0;i<start.length;i++)
        {
            if(!tree.containsKey(end[i]))
                tree.put(end[i], start[i]);
            else if(tree.get(end[i]) < start[i])
                tree.put(end[i], start[i]);
        }
        Iterator<Integer> itr = tree.keySet().iterator();
        while (itr.hasNext())
        {
            int key = itr.next();
            if(tree.get(key) > end_meet)
            {
                end_meet = key;
                ++count;
            }
        }
        return(count);
    }
}
