import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> ans1=new ArrayList<>();
        int c=0;
        HashMap<Integer, Integer> ans= new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!ans.containsKey(nums[i]))
            {
                ans.put(nums[i],1);
            }
            else
            {
                ans.put(nums[i],ans.get(nums[i])+1);
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            ans.put(nums[i],ans.get(nums[i])-1);
            if(ans.containsKey(target-nums[i]) && ans.get(target-nums[i])>0) 
            {
                ans1.add(i);
            }
            ans.put(nums[i],ans.get(nums[i])+1);
        }
        int arr[]= new int[ans1.size()];
        for(int i=0;i<ans1.size();i++)
        {
            arr[i]=ans1.get(i);
        }
        return arr;
    }
}