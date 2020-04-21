public class Pair
{
    final int x;
    final int y;
    
    public Pair(int xx, int yy)
    {
        x = xx;
        y = yy;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }  
}
class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int maxGold = 0;
        if(grid.length == 0)
            return 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] != 0)
                {
                    Set<Integer> visited = new HashSet<Integer>();
                    int currMax = dfs(i, j, grid, visited);
                    if(currMax > maxGold)
                        maxGold = currMax;
                }
            }
        }
        return maxGold;
    }
    
    int dfs(int i, int j, int [][] grid, Set<Integer> visited)
    {
       // System.out.println(" DFS " + i + " "  + j);
        int index = getIndex(i,j,grid);
        int gMax = 0;
        int res = 0;
        if(visited.contains(index))
            return 0;
        
        if(grid[i][j] == 0)
            return 0;
        // choose
        visited.add(index);
        
        //explore
        List<Pair> nbs = getNeightbors(i,j,grid);
        for(Pair nb : nbs)
        {
            //if(!visited.contains(nb))
            {
                int currMax = dfs(nb.getX(),nb.getY(),grid,visited);
                if(currMax > gMax)
                    gMax = currMax;
            }
        }
        
        visited.remove(index);
        res = gMax + grid[i][j];
        return res;
        
        
    }
    
    int getIndex(int r, int c, int [][] grid)
    {
        int index = r * grid[0].length + c;
        return index;
    }
    
    List<Pair> getNeightbors(int i, int j, int [][] grid)
    {
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        List<Pair> res = new LinkedList<>();
        for(int ii = 0; ii < 4; ii++)
        {
            int x = dx[ii] + i;
            int y = dy[ii] + j;
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
                continue;
            
            Pair nb = new Pair(x,y);
            res.add(nb);
        }
        
        return res;
    }
}
