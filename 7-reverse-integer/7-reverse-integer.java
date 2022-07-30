class Solution {
    public int reverse(int x) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;
        long y = 0;
        int t = x;
        if(x < 0)
            x = (-1) * x;
        while(x > 0)
        {
            int temp = x % 10;
            x /= 10;
            y = (y*10) + temp;
        }
        if(t<0)
            y = (-1) * y;
        if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
            return 0;
        return (int)y;
    }
}