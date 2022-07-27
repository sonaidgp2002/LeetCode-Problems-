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
        /*
        int c=0, m=Integer.MIN_VALUE;
        int[][] arr=new int[nums.length][nums.length];
        arr[0][0]=nums[0];
        if(nums.length==1 && nums[0]==k)
            return 1;
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++)
                arr[i][j]=m;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(j==0)
                    arr[i][j]=nums[i];
                else if(arr[i-1][j-1]==m)
                    continue;
                else
                    arr[i][j]=nums[i]+arr[i-1][j-1];
                if(arr[i][j]==k)
                    c++;
            }
        }
        return c;
        int temp=0;
        int x=0;
        for(int i=0;i<nums.length;i++)
        {
            x=check(nums, 0, k, 0);
            if(x!=0)
                temp++;
        }
        return temp;*/
    /*public int check(int[] nums, int s, int k, int sum)
    {
        if(sum==k)
            return s;
        else if(s!=nums.length-1)
            return check(nums, s+1, k, sum+nums[s]);
        else 
            return 0;
    }
    
    public int check(int nums[], int s, int l, int k)
    {
        int mid=l+(l-s)/2;
        if(s+1==l)
            return nums[s]+nums[l];
        else
        {
            int x=check(nums, s, mid);
            int y=check(nums, mid,l);
            if(x==k)
                return mid;
            else if(y==k)
                return l;
            else
                return x+y;
        }*/