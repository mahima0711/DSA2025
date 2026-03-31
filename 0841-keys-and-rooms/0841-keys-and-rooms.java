class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];

            if(!visited[0])
            {
                dfs(rooms, 0, visited);
            }

        for(int i=0;i<visited.length;i++)
        {
            if(visited[i] == false)
            {
                return false;
            }
        }

        return true;
    }

    void dfs(List<List<Integer>> rooms, int u, boolean visited[])
    {
        visited[u] = true;

        for(int v : rooms.get(u))
        {
            if(!visited[v])
            {
                dfs(rooms, v, visited);
            }
        }
    }
}