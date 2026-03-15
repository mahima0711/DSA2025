class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) 
            adj.add(new ArrayList<>());

        for(int p[] : prerequisites)
        {
            adj.get(p[1]).add(p[0]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean isRecursion[] = new boolean[numCourses];

        for(int i=0;i< numCourses ;i++)
        {
            if(!visited[i] && isCycleDFS(adj, i, visited, isRecursion))
            {
                return false;
            }
        }

        return true;
    }

    boolean isCycleDFS(List<List<Integer>> adj, int u, boolean[] visited, boolean[] isRecursion)
    {
        visited[u] = true;
        isRecursion[u] =true;

        for(int v : adj.get(u))
        {
            if(!visited[v] && isCycleDFS(adj, v, visited, isRecursion))
            {
                return true;
            }
            else if(isRecursion[v])
            {
                return true;
            }
        }

        isRecursion[u] = false;
        return false;
    }

}