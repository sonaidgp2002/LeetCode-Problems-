class Solution {
    public boolean validPalindrome(String s) {/*
        String str="";
        for(int i=0;i<s.length();i++)
        {
            str+=s.substring(0,i);
            if(i+1<s.length())
            str+=s.substring(i+1,s.length());
            StringBuilder input = new StringBuilder();
            //if(check(str, 0, str.length()-1))
            input.append(str);
            input.reverse();
            String str1 = input.toString();
            if(str.equals(str1))
                return true;
            str="";
        }
        return false;*/
        return check(s, 0, s.length()-1);
    }
    public boolean check(String s, int i, int j)
    {
        if(i==j || j<i)
            return true;
        else if(s.charAt(i)!=s.charAt(j))
        {
            String str="";
            str+=s.substring(0,i);
            if(i+1<s.length())
            str+=s.substring(i+1,s.length());
            StringBuilder input = new StringBuilder();
            input.append(str);
            input.reverse();
            String str1 = input.toString();
            if(str.equals(str1))
                return true;
            input.setLength(0);
            str="";
            str1="";
            str+=s.substring(0,j);
            if(j+1<s.length())
            str+=s.substring(j+1,s.length());
            input.append(str);
            input.reverse();
            str1 = input.toString();
            if(str.equals(str1))
                return true;
            else
                return false;
        }
        else
            return check(s, i+1, j-1);
    }
}