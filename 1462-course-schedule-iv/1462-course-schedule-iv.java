class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        Queue<Integer> qu = new LinkedList<>();

        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i] == 0)
            {
                qu.offer(i);
            }
        }

         Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }

        while(!qu.isEmpty())
        {
            int curr = qu.poll();

            for(int nei : adj.get(curr))
            {
                map.get(nei).add(curr);
                map.get(nei).addAll(map.get(curr));

                indegree[nei]--;
                if(indegree[nei] == 0) {
                    qu.offer(nei);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(map.get(query[1]).contains(query[0]));
        }
        return res;
    }
}