class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i< numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites)
        {
            adj.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i] && topologicalSortDFS(adj, visited, pathVis, stack, i))
            {
                return new int[0];
            }
            
        }

        int i=0;
        while(!stack.isEmpty())
        {
            ans[i] = stack.pop();
            i++;
        }

        return ans;
    }

    boolean topologicalSortDFS(List<List<Integer>> adj, boolean[] visited, boolean[] pathVis, Stack<Integer> stack, int u)
    {
        visited[u] = true;
        pathVis[u] = true;

        for(int v : adj.get(u))
        {
            if(!visited[v] && topologicalSortDFS(adj, visited, pathVis, stack, v))
            {
                return true;
            }
            else if(pathVis[v])
            {
                return true;
            }
        }

        pathVis[u] = false;
        stack.push(u);

        return false;
    }
}