class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) 
            adj.add(new ArrayList<>());

        int inDegree[] = new int[numCourses];

        for(int p[] : prerequisites)
        {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();

        int count=0;

        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i] == 0)
            {
                que.offer(i);
            }
        }

        while(!que.isEmpty())
        {
            int curr = que.poll();
            count++;

            for(int v : adj.get(curr))
            {
                inDegree[v]--;

                if(inDegree[v] == 0)
                {
                    que.offer(v);
                }
            }
        }

        if(count == numCourses)
           return true;

        return false;
    }

}