class Solution {

    public int islandPerimeter(int[][] grid) {
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                   return dfs(grid, i, j);
                }
            }
        }

        return -1;
    }

    int dfs(int[][] grid, int i, int j)
    {
        if(i<0 || j<0 || i >= grid.length || j>= grid[0].length || grid[i][j]==0)
        {
            return 1;
        }

        if (grid[i][j] == -1) {
            return 0;
        }

        grid[i][j] = -1;

        int perimeter = 0;

        perimeter += dfs(grid, i - 1, j);
        perimeter += dfs(grid, i + 1, j);
        perimeter += dfs(grid, i, j - 1);
        perimeter += dfs(grid, i, j + 1);

        return perimeter;
    }
}