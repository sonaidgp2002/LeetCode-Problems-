//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xr = 0;
        for(int i=0;i<n;i++){
            xr ^= (i + 1) ^ arr[i];
        }
        int bitno = 0;
        while(true){
            if((xr & (1 << bitno)) != 0){
                break;
            }
            bitno++;
        }
        int one = 0;
        int zero = 0;
        for(int i=0;i<n;i++){
            if((arr[i] & (1 << bitno)) != 0){
                one ^= arr[i];
            }
            else{
                zero ^= arr[i];
            }
        }
        for(int i=1;i<=n;i++){
            if((i & (1 << bitno)) != 0){
                one ^= i;
            }
            else{
                zero ^= i;
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == zero)
                cnt++;
        }
        if(cnt == 2)
            return new int[] {zero, one};
        return new int[] {one, zero};
    }
}