public class Solution {
    public List<List<Integer>> generate(int numRows) {
        int curMax = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //add a seed
        if(numRows > 0)
        {
            List<Integer> one = new ArrayList<Integer>();
            one.add(1);
            result.add(one);
            curMax++;
        }
        
        if(numRows > 1)
            while(curMax <= numRows)
            {
                boolean isEven = false;
                if(curMax % 2 == 0)
                    isEven = true;
                    
                List<Integer> subList = makeSubList(isEven, result.get(result.size()-1));
                result.add(subList);
                curMax++;
            }
        
        for(List<Integer> sublist : result)
            System.out.println(sublist);
        return result;
    }
    
    
    public List<Integer> makeSubList(boolean isEven, List<Integer> previousList)
    {
        List<Integer> subList = new ArrayList<>();
        subList.add(1);
        int max = previousList.size() - 1;
        for(int i = 0; i < max; i++) //stop when i is at second last index
        {
            int sum = previousList.get(i) + previousList.get(i+1);
            subList.add(sum);
        }
        subList.add(1);
        return subList;
    }
}