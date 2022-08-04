class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 1)
            return 1;
        int len = 0;
        int length = 0;
        if(s.charAt( 0 ) != ' ')
            len++;
        for(int i = 1; i<s.length();i++)
        {
            if(s.charAt(i - 1) == ' ' && s.charAt(i) != ' ')
            {
                len = 1;
            }
            else if(s.charAt(i) == ' ')
                continue;
            else
                len++;
        }
        if(len == 0)
            return length;
        return len;
    }
}