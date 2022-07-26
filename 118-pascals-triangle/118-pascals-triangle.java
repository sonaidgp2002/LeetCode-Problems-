import java.util.ArrayList;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> subset = new ArrayList<>();
        if(numRows<=0)
            return subset;
        for(int i=0;i<numRows;i++)
        {
            List<Integer> list= new ArrayList<Integer>();
            for(int j=0;j<i+1;j++)
            {
                if(j==0 || j==i)
                    list.add(1);
                else
                    list.add(subset.get(i-1).get(j-1)+subset.get(i-1).get(j));
            }
            subset.add(list);
        }
        return subset;
    }
}