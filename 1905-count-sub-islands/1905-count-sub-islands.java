class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans =0;
        for(int i=0; i< grid2.length;i++)
        {
            for(int j=0;j<grid2[0].length;j++)
            {
                if(grid2[i][j] == 1)
                {
                    if(dfs(grid1, grid2, i, j))
                    {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    boolean dfs(int[][] grid1, int[][] grid2, int i, int j)
    {
        if(i<0 || j<0 || i >= grid2.length || j>= grid2[0].length || grid2[i][j] == 0)
        {
            return true;
        }

        grid2[i][j] = 0;

        boolean isSubIsland = (grid1[i][j] == 1);

        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean right = dfs(grid1, grid2, i, j + 1);
        boolean left = dfs(grid1, grid2, i, j - 1);

        return isSubIsland && down && up && right && left;
    }
}