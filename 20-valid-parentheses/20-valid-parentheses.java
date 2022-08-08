class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1)
            return false;
        Stack<Character> stk = new Stack<>();
        // Stack<Character> stk1 = new Stack<>();
        // ArrayList<Character> arr = new ArrayList<>();
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
        }
        // for(int i=s.length()-1;i>=0;i--)
        // {
        //     if(stk.isEmpty())
        //         break;
        //     if(( s.charAt(i) == ')' && stk.peek() == '(') || ( s.charAt(i) == ']' && stk.peek() == '[') || ( s.charAt(i) == '}' && stk.peek() == '{'))
        //         stk.pop();
        // }
        // int i = 0;
        // int j = arr.size() - 1;
        // for(;i!=j && i<j; i++, j--)
        // {
        //     if( (arr.get(i) == '(' && arr.get(j) != ')') || (arr.get(i) == '[' && arr.get(j) != ']') || (arr.get(i) == '{' && arr.get(j) != '}') )
        //         return false;
        // }
        // while(!stk.isEmpty() && !stk1.isEmpty())
        // {
        //     if(stk.peek() == '(' && stk.pop() + 1 != stk1.pop())
        //         return false;
        //     else if(stk.size() !=0 && stk1.size() != 0 && stk.pop() + 2 != stk1.pop())
        //         return false;
        // }
        // if(stk.size() != 0 || stk1.size() != 0)
        //     return false;
        if(!stk.isEmpty())
            return false;
        return true;
    }
}