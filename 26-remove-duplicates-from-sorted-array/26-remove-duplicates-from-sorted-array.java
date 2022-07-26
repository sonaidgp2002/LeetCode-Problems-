class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0,l=1;
        k=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==k)
                continue;
            else
            {
                k=nums[i];
                nums[l]=k;
                l++;
            }
        }
        return l;
    }
}