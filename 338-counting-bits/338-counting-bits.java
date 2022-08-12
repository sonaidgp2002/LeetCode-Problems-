class Solution {
    public int[] countBits(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for(int i=1; i<= n;i++)
        {
            dp[i] = dp[i/2] + i%2;
        }
        // int c = 2;
        // arr[0] = 0;
        // for(int i=1; i<=n ;i++)
        // {
        //     if(i % 2 != 0)
        //         arr[i] = arr[i - 1] + 1;
        //     else if(c == i)
        //     {
        //         c *= 2;
        //         arr[i] = 1;
        //     }
        //     else if(i % 10 == 0 || i % 12 == 0)
        //         arr[i] = 2;
        //     else
        //         arr[i] = arr[i - 1];
        // }
        return dp;
    }
}