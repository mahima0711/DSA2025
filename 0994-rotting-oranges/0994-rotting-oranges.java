class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int freshOranges = 0;

        int min=0;

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1){
                    freshOranges++;
                }

                if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty() && freshOranges > 0)
        {
            int size = q.size();

            min++;

            for(int i=0;i<size;i++)
            {
                int curr[] = q.poll();

                for(int d[] : dir)
                {
                    int n1 = curr[0] + d[0];
                    int m1 = curr[1] + d[1];

                    if(n1>=0 && m1>=0 && n1<grid.length && m1< grid[0].length && grid[n1][m1]==1){
                        grid[n1][m1]=2;
                        q.add(new int[]{n1,m1});
                        freshOranges--;
                    }
                }
            }
        }

        if(freshOranges == 0)
        {
            return min;
        }

        return -1;
    }
}