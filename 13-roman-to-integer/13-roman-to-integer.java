class Solution {
    public int romanToInt(String s) {
        int sum=0;
        HashMap<Character, Integer> map1= new HashMap<>();
        map1.put('I',1);
        map1.put('V',5);
        map1.put('X',10);
        map1.put('L',50);
        map1.put('C',100);
        map1.put('D',500);
        map1.put('M',1000);
        for(int i=0;i<s.length()-1;i++)
        {
            int a=map1.get(s.charAt(i));
            int b=map1.get(s.charAt(i+1));
            if(a<b)
                sum-=a;
            else
                sum+=a;
        }
        return sum+map1.get(s.charAt(s.length()-1));
    }
}