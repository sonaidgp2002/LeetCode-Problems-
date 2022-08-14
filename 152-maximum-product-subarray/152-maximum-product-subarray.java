class Solution {
    public int maxProduct(int[] nums) {
        // if(nums.length == 0)
        //     return 0;
        // else if(nums.length == 1)
        //     return nums[0];
        // int max = 0;
        // int pro = 1;
        // for(int i=0; i<nums.length; i++)
        // {
        //     if(pro <= (nums[i] * pro))
        //     {
        //         pro *= nums[i];
        //     }
        //     else
        //     {
        //         max = Math.max(max, pro);
        //         if(pro == 1)
        //             max = 0;
        //         pro = 1;
        //     }
        // }
        // return max;
        int n = nums.length;
        int l=1,r=1;
        int ans=nums[0];
        
        for(int i=0;i<n;i++){
            if(l == 0)
                l = 1;
            if(r == 0)
                r=1;
            
            l *= nums[i];  
            r *= nums[n-1-i];   
            
            ans = Math.max(ans,Math.max(l,r));
            
        }
        
        return ans;
    }
}