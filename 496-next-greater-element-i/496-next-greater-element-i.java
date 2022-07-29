class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int k=nums1.length-1;
        int c=0;
        int[] arr=new int[nums1.length];
        Stack<Integer> stk= new Stack<>();
        for(int i=0;i<nums1.length;i++)
            stk.push(nums1[i]);
        while(!stk.isEmpty())
        {
            for(int i=0;i<nums2.length;i++)
            {
                if(stk.peek()==nums2[i])
                    c++;
                if(stk.peek()<nums2[i] && c>0)
                {
                    c++;
                    arr[k--]=nums2[i];
                    break;
                }
            }
            if(c<=1)
            {
                arr[k--]=-1;
                c=0;
            }
            else
                c=0;
            stk.pop();
        }
        /*for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums2[j]==nums1[i])  
                {
                    c=nums2[j];
                }
                if(nums2[j]>c)
                {
                    arr[k++]=nums2[j];
                    c1++;
                    break;
                }
            }
            if(c1==0)
                arr[k++]=-1;
            else
                c1=0;
        }*/
        return arr;
    }
}