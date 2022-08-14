class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        for(int i=0; i<nums.length + 1; i++)
        {
            for(int j=0; j<nums.length + 1; j++)
                dp[i][j] = -1;
        }
        return check(nums, 0, -1, dp);
    }
    public int check(int[] nums, int index, int prev_ind, int dp[][])
    {
        if(index == nums.length)
            return 0;
        if(dp[index][prev_ind + 1] != -1)
            return dp[index][prev_ind + 1];
        int lh = check(nums, index + 1, prev_ind, dp);
        int rh = 0; 
        if(prev_ind == -1 || nums[index] > nums[prev_ind])
            rh = 1 + check(nums, index + 1, index, dp);
        dp[index][prev_ind + 1] = Math.max(lh, rh);
        return  dp[index][prev_ind + 1];
    }
}