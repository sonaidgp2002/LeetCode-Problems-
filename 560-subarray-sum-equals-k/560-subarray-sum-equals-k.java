class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,c=0;
        for(int i=0;i<nums.length;i++)
        {
            
            for(int j=i;j>=0;j--)
            {
                sum+=nums[j];
                if(sum==k)
                {   
                    c++;
                    //sum=0;
                }
            }
            sum=0;
        }
        return c;
    }
}
