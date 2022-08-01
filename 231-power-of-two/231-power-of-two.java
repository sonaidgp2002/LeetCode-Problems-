class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        if(n == 1)
             return true;
        while(n > 1)
        {
            if(n % 2 != 0)
                return false;
            else
                n /= 2;
        }
        return true;
        // if(n == 1)
        //     return true;
        // if(n % 2 == 0)
        // for(int i=0;i<n;i++)
        // {
        //     if((int)Math.pow(2,i) > Integer.MAX_VALUE)
        //         return false;
        //     else if(n == (int)Math.pow(2,i))
        //         return true;
        //     else
        //         return false;
        // }
        // // else if(n % 2 == 0)
        // //     return true;
        // return false;
    }
}