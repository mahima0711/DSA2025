class Solution {

    int dp[][];
    public int calculateMinimumHP(int[][] dungeon) {
        
        int m = dungeon.length;
        int n = dungeon[0].length;

        dp = new int[201][201];

        for(int i=0;i<201;i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0,m, n, dungeon);
    }

    int solve(int i, int j, int m, int n, int[][] dungeon)
    {
        if(i >= m || j>= n)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        if(i == m-1 && j == n-1)
        {
            if(dungeon[i][j] > 0)
            {
                return 1;
            }

            return Math.abs(dungeon[i][j]) + 1;
        }

        int right = solve(i, j+1, m, n, dungeon);

        int down = solve(i+1, j, m, n, dungeon);

        int result = Math.min(down, right) - dungeon[i][j];

        return dp[i][j] = result > 0 ? result : 1;
    }
}