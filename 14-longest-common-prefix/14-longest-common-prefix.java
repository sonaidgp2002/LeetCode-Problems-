class Solution {
    public String longestCommonPrefix(String[] strs) {
        int max=Integer.MAX_VALUE, c=0;
        String str="";
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].length()<max)
                max=strs[i].length();
        }
        for(int i=0;i<max;i++)
        {
            String str1=strs[0].substring(0,i+1);
            for(int j=1;j<strs.length;j++)
            {
                if(str1.equals(strs[j].substring(0,i+1)))
                    c++;
            }
            if(c==strs.length-1)
            {
                c=0;
                str=str1;
            }
            else 
                break;
        }
        return str;
    }
}