class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            dp[i] = -1;
        return check(nums, nums.length - 1, dp);
    }
    public int check(int[] nums, int n, int[] dp)
    {
        if(n == 0)
            return nums[n];
        if(n < 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        int pick = nums[n] + check(nums, n - 2, dp);
        int not_pick = 0 + check(nums, n - 1, dp);
        dp[n] = Math.max(pick, not_pick);
        return dp[n];
    }
}