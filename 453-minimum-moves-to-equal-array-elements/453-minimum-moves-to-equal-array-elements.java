class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i< nums.length;i++)
        {
            count = count + nums[i] - nums[0]; 
        }
        return count;
    }
}