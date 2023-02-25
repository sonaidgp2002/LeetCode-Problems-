//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String str) {
        // Code here
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            String s = String.valueOf(str.charAt(i));
            if(hash.containsKey(s))
                hash.put(s, hash.get(s) + 1);
            else
                hash.put(s, 1);
        }
        ArrayList<String> str1 = new ArrayList<>();
        check(0, str, "", str1, hash);
        Collections.sort(str1);
        return str1;
    }
    static void check(int n,String str, String s1, List<String> str1, HashMap<String, Integer> hash)
    {
        if(n == str.length()) {
            if(!str1.contains(s1) && s1.length() == str.length())
                str1.add(s1);
            return;
        }
        Iterator<String> itr = hash.keySet().iterator();
        while(itr.hasNext())
        {
            String key = itr.next();
            if(hash.get(key) > 0)
            {
                hash.put(key, hash.get(key) - 1);
                String s2 = s1;
                s2 += key;
                check(n+1, str, s2, str1, hash);
                hash.put(key, hash.get(key) + 1);
            }
        }
    }
}