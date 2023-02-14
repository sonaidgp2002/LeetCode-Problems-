//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> hash = new HashMap<>();
        int i = 0, j = 0, max = -1;
        while(j<s.length() && i<s.length())
        {
            char ch = s.charAt(j);
            if(hash.containsKey(ch))
                hash.put(ch, hash.get(ch) + 1);
            else
                hash.put(ch, 1);
            if(hash.size() < k)
                j++;
            else if(hash.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(hash.size() > k) {
                while(hash.size() > k)
                {
                    ch = s.charAt(i);
                    hash.put(ch, hash.get(ch) - 1);
                    if(hash.get(ch) == 0)
                        hash.remove(ch);
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}