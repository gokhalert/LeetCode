class Solution {
     
    Set<Integer> gray = new HashSet<Integer>();
    Set<Integer> black = new HashSet<Integer>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(numCourses <= 1)
            return true;
        
        Map<Integer,List<Integer>> adjList = getAdjList(prerequisites);
        for(Map.Entry<Integer,List<Integer>> mm : adjList.entrySet())
        {   
            int course = mm.getKey();
            if(! black.contains(course))
            {              
                boolean res = recCanFinish(course, adjList);
                if(res == false)
                    return false;
            }
        }  
        return true;
    }
    
    public boolean recCanFinish(int course, Map<Integer,List<Integer>> adjList)
    {
        
        if(gray.contains(course))
            return false;
        
        gray.add(course);
        
        if(adjList.containsKey(course))
        {
            for(Integer nb : adjList.get(course))
            {
                if(! black.contains(nb))
                {
                    boolean res = recCanFinish(nb,adjList);
                    if(res == false)
                        return false;
                }
            }
        }
        
        gray.remove(course);
        black.add(course);
        
        return true;
    }
    
    public Map<Integer,List<Integer>> getAdjList(int [][] preReq)
    {
        Map<Integer,List<Integer>> result = new HashMap<>();
        
        for(int i = 0; i < preReq.length; i++)
        {
            int x = preReq[i][0];
            int y = preReq[i][1];
            if(result.containsKey(y))
            {
                result.get(y).add(x);
            }
            else
            {
                List<Integer> ll = new LinkedList<>();
                ll.add(x);
                result.put(y,ll);
            }
        }
        
        return result;
    }
}
