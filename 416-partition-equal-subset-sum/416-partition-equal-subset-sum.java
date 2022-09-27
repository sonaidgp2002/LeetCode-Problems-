class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
        }
        if(sum%2!=0)
            return false;
        int k = sum/2;
        int n = nums.length;
        int dp[][] = new int[n+1][k+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=k;j++)
                dp[i][j] = -1;
        return check(nums, sum/2,nums.length-1, dp);
    }
    public boolean check(int[] nums, int k, int n,int dp[][])
    {
        if(k==0)
            return true;
        if(k<0 || n<0)
            return false;
        if(n==0)
            return nums[0] == k;
        if(dp[n][k] != -1)
            return dp[n][k] == 0?false:true;
        boolean notpick = check(nums, k, n-1, dp);
        boolean pick = false;
        if(nums[n]<=k && notpick==false)
        {
            pick = check(nums, k-nums[n], n-1, dp);
        }
        dp[n][k] = (pick | notpick)?1:0;
        return  (pick | notpick);
    }
}