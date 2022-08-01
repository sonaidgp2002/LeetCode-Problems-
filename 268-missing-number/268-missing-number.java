class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums[nums.length-1];i++)
        {
            if(nums[i]!=i)
                return i;
        }
        return (nums[nums.length-1] + 1);
        /*
        Arrays.sort(nums);
        if(nums.length == 1)
        {
            if(nums[0] > 0)
                return (nums[0] - 1);
            return (nums[0] + 1);
        }
        int temp = nums[1] - nums[0];
        for(int i = 1;i < nums.length; i++)
        {
            if((nums[i] - nums[i-1]) !=temp)
                return (nums[i] - temp);
        }
        return (nums[nums.length-1] + temp);*/
    }
}