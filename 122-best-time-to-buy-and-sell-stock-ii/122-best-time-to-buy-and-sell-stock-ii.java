class Solution {
    public int maxProfit(int[] prices) {/*
        ArrayList<Integer> arr=new ArrayList<>();
        int sum=0;
        for(int i=0;i<prices.length;i++)
            arr.add(prices[i]);
        for(int i=0;i<prices.length;i++)
        {
            int t=arr.remove(i);
            int j=Collections.max(arr);
            if(t<j)
            {
                if(arr.get(arr.indexOf(j)+1)<j)
                    
            }
            else
                continue;
        }*/
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i]>prices[i+1])
                continue;
            else
                sum+=prices[i+1]-prices[i];
        }
        return sum;
    }
}