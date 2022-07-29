class Solution {
    public int search(int[] nums, int target) {
        int c=check(nums, 0, nums.length-1,target);
        return c;
    }
    public int check(int[] nums, int s, int l, int t)
    {
        if(l>=s)
        {
            int m=s+(l-s)/2;
        if(t==nums[m])
            return m;
        else if(t>nums[m])
            return check(nums, m+1, l, t);
        else if(t<nums[m])
            return check(nums, 0, m-1, t);
        }
        return -1;
    }
}