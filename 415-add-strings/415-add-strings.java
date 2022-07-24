class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0,sum=0;
        String str="";
        while(i>=0 || j>=0 || carry!=0)
        {
            int ival= i>=0? num1.charAt(i)-'0':0;
            int jval= j>=0? num2.charAt(j)-'0':0;
            i--;
            j--;
            sum=ival+jval+carry;
            str=(sum%10)+str;
            carry=(sum/10);
        }
        return str;
    }
}