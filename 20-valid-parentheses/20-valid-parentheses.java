class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1)
            return false;
        Stack<Character> stk = new Stack<>();
        for( int i=0; i<s.length(); i++)
        {
            if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' )
                stk.push(s.charAt(i));
            else if( s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
            {
                Character ch = ' ';
                if(!stk.isEmpty())
                    ch = stk.pop();
                if((ch != '(' && s.charAt(i) == ')' ) || (ch != '[' && s.charAt(i) == ']') || (ch != '{' && s.charAt(i) == '}'))
                    return false;
            }
        }if(!stk.isEmpty())
            return false;
        return true;
    }
}