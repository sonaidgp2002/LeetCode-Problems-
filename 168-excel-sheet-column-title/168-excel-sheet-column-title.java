class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0)
        {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}