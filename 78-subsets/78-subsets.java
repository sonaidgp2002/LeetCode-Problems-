class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        ArrayList<Integer> output= new ArrayList<Integer>();
        check(nums, 0, subset, output);
        return subset;
    }
    public void check(int[] nums, int start, List<List<Integer>> subset, ArrayList<Integer> output)
    {
        if(start==nums.length)
        {
            subset.add(output);
            return;
        }
        ArrayList<Integer> output1= new ArrayList<Integer>(output);
        output.add(nums[start]);
        check(nums, start+1, subset, output);
        check(nums, start+1, subset, output1);
        // char charArray[] = s.toCharArray();
        // char charArray1[] = t.toCharArray();
        // Arrays.sort(charArray);
        // Arrays.sort(charArray1);
        // s = new String(charArray);
        // t = new String(charArray1);
        // if(s.equals(t))
        //     return true;
        // return false;
    }
}