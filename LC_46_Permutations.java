class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return res;
       
        List<Integer> l = new LinkedList<>();
        List<List<Integer>> subR = new LinkedList<>();
        subR.add(l);
       
        dfs(nums,0,subR);
        return res;
    }
   
    public void dfs(int [] nums, int idx, List<List<Integer>> subR)
    {
        List<List<Integer>> subRes = new LinkedList<>();
       
        if(idx == nums.length)
        {
            for(List<Integer> iter : subR)
            {
                res.add(iter);
            }
            return;
        }
       
        int val = nums[idx];
        for(List<Integer> sub : subR)
        {
            for(int i = 0; i <= sub.size(); i++)
            {
                List<Integer> subList = deepCopy(sub);
                subList.add(i,val);
                subRes.add(subList);
            }
        }
       
        dfs(nums,idx+1,subRes);
    }
   
    public List<Integer> deepCopy(List<Integer> list)
    {
        List<Integer> res = new LinkedList<>();
        for(Integer i : list)
        {
            res.add(i);
        }
        return res;
    }
}
