class Solution {
    public int maximumProduct(int[] nums) {
        /*
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            max = nums[i] * nums[i+1];
            for(int j = i+1; j < nums.length; j++)
            {
                if(max < nums[i] * nums[j])
                    max = nums[i] * nums[i+1];
            }
        }  
        for(int i = 2; i < nums.length; i++)
        {
            if( max < (max * nums[i]));
        }  
        return max;*/
        /*
        ArayList<Integer> arr= new ArrayList<Integer>();
        for(int i = 0; i < nums.length - 1; i++)
        {
            arr.add(nums[i]);
        } 
        Arrays.sort(nums);
        if(nums[0] < 0 && nums[1] < 0)
        {
            nums[0] = (-1) * nums[0];
            nums[1] = (-1) * nums[1];
        }
        Arrays.sort(nums);
        return (nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3]);*/
        // int max = 0;
        // int temp = 0;
        // for(int i = 0; i < nums.length-1 ; i++)
        // {
        //     for(int j= i+1; j < nums.length; j++)
        //     {
        //         if(max < (nums[i] * nums[j]))
        //         {
        //             max = nums[i] * nums[j];
        //             temp = j;
        //         }
        //     }
        // }
        // for(int i = temp + 1; i < nums.length; i++ )
        //     if(max < (max * nums[i]))
        //         max = max * nums[i];
        // return max;
        Arrays.sort(nums);
        int max = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        if(max < (nums[0] * nums[1] * nums[nums.length-1]))
            max = nums[0] * nums[1] * nums[nums.length-1];
        return max;
    }
}