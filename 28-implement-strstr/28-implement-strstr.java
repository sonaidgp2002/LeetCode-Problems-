class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==haystack.length() && needle.equals(haystack))
            return 0;
        else if(needle.length()<haystack.length())
        {
            for(int i=0;i<=haystack.length()-needle.length();i++)
            {
                if(haystack.substring(i,i+needle.length()).equals(needle))
                    return i;
            }
        }
        /*else if(needle.length()==haystack.length())
        {
            for(int i=0;i<haystack.length();i++)
            {
                if(haystack.substring(i,i+needle.length()).equals(needle))
                    return i;
            }
        }*/
        return -1;
    }
}