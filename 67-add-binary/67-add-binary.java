class Solution {
    public String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
        /*
        int i = a.length-1;
        int j = b.length-1;
        String res="";
        String carry;
        int sum=0;
        while(a >= 0 && b >= 0)
        {
            if(a.charAt(i) == '1' && b.charAt(i) == '1')
            {
                carry = "1";
                res = "0" + res;
            }
            else if(a.charAt(i) == '1' && b.charAt(i) == '1')
            {
                carry = "1";
                res = "1" + res;
            }
            else if(((a.charAt(i) == '1' || b.charAt(i) == '0') || (a.charAt(i) == '0' || b.charAt(i) == '1')) && carry.length==1)
            {
                carry = "1";
                res = "0" + res;
            }
            else if((a.charAt(i) == '1' && b.charAt(i) == '0') || (a.charAt(i) == '0' && b.charAt(i) == '1') && carry.length==1)
            {
                sum = (a.charAt(i) - '0') + (a.charAt(i) - '0');
                carry = "1";
                res = "0" + res;
            }
            else if((a.charAt(i) == '0' && b.charAt(i) == '0') && carry.length==1)
            {
                res = "1" + res;
                carry = "";
            }
            else if((a.charAt(i) == '1' && b.charAt(i) == '0') || (a.charAt(i) == '0' && b.charAt(i) == '1') ||(a.charAt(i) == '0' && b.charAt(i) == '0'))
            {
                sum = (a.charAt(i) - '0') + (a.charAt(i) - '0');
                res = String.valueOf(sum) + res;
            }
            a--;
            b--;
        }
        if(a>=0)
        {
            if(carry.length == 1)
            {
                
            }
        }
        else if(b>=0)
        {
            if(carry)
        }
        return res;
        /*
        int x=1;
        long sum=0;
        for(int i=a.length()-1;i>=0;i--)
        {
            sum+=(a.charAt(i)-'0')*x;
            x*=2;
        }
        x=1;
        for(int i=b.length()-1;i>=0;i--)
        {
            sum+=(b.charAt(i)-'0')*x;
            x*=2;
        }
        a="";
        if(sum==0)
            return "0";
        while(sum>0)
        {
            int t=(int)sum%2;
            a = String.valueOf(t) + a;
            sum /= 2;
        }
        return a;*/
    }
}