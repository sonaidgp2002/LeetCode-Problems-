//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int sum = 0;
        // int max = Integer.MIN_VALUE;
        int max = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == 0)
                max = Math.max(max, i + 1);
            else if(hash.containsKey(sum)){
                max = Math.max(max, i - hash.get(sum));
            }
            else
                hash.put(sum, i);
        }
        return max;
    }
}