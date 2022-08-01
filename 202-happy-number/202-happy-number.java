class Solution {
    public boolean isHappy(int n) {
        int sum = n;
        while(sum != 1)
        {
            int temp = sum;
            sum = 0;
            while(temp > 0)
            {
                sum += ((temp % 10) * (temp % 10));
                temp /= 10;
            }
            if(((sum / 10) == 0) && sum != 1 && sum!= 7)
                return false;
        }
        return true;
    }
}