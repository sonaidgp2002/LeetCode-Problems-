class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<String> stk= new Stack<>();
        Stack<String> stk1=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='#')
            {
                if(!stk.isEmpty())
                    stk.pop();
                else
                    continue;
            }
            else
            {
                Character c=s.charAt(i);
                stk.push(c.toString());
            }
        }
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='#')
             {
                if(!stk1.isEmpty())
                    stk1.pop();
                else
                    continue;
             }
            else
            {
                Character c=t.charAt(i);
                stk1.push(c.toString());
            }
        }
        s="";
        t="";
        while(!stk.isEmpty())
            s=stk.pop()+s;
        while(!stk1.isEmpty())
            t=stk1.pop()+t;
        if(s.equals(t))
               return true;
        return false;
    }
}