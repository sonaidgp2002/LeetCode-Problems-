class Solution {
    public boolean divisorGame(int n) {
        int c = 0;
        while(n != 1)
        {
            c++;
            n -= 1;
        }
        if(c % 2 == 0)
            return false;
        else
            return true;
    }
}