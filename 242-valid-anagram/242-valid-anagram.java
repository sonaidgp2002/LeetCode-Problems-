class Solution {
    public boolean isAnagram(String s, String t) {
        // String m = s;
        // String n = s;
        // if(m.equals(t))
        //     return true;
        // for(int i=0; i<s.length(); i++)
        // {
        //     Character ch = s.charAt(i);
        //     m = s.substring(0,i) + s.substring(i+1, s.length());
        //     for( int j=0; j<m.length(); j++)
        //     {
        //         n = m.substring(0,j) + ch.toString() + m.substring(j+1, m.length());
        //         if(n.equals(t))
        //             return true;
        //     }
        // }
        // return false;
    //     List<List<String>> subset = new ArrayList<>();
    //     ArrayList<String> output= new ArrayList<String>();
    //     check(s, 0, subset, output);
    //     System.out.println(subset);
    //     return true;
    // }
    // public void check(String s, int start, List<List<String>> subset, ArrayList<String> output)
    // {
    //     if(start==s.length())
    //     {
    //         if(output.size() == s.length())
    //         subset.add(output);
    //         return;
    //     }
    //     ArrayList<String> output1= new ArrayList<String>(output);
    //     Character ch = s.charAt(start);
    //     output.add(ch.toString());
    //     check(s, start+1, subset, output);
    //     check(s, start+1, subset, output1);
        char charArray[] = s.toCharArray();
        char charArray1[] = t.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);
        s = new String(charArray);
        t = new String(charArray1);
        if(s.equals(t))
            return true;
        return false;
    }
}