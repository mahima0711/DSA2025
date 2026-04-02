class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, Integer> indegree = new HashMap<>();

        List<String> ans = new ArrayList<>();

        Map<String, List<String>> graph = buildGraph(recipes, ingredients, indegree);

        Queue<String> queue = new ArrayDeque<>();

        for (String supply: supplies) { // yeast, flour, meat
            queue.offer(supply);
        }

        while(!queue.isEmpty())
        {
            String sup = queue.poll();

            if (!graph.containsKey(sup)) continue;

            for(String nei : graph.get(sup))
            {
                indegree.put(nei, indegree.get(nei)-1);

                if(indegree.get(nei) == 0)
                {
                    ans.add(nei);
                    queue.offer(nei);
                }
            }
        }

        return ans;
       
    }

    private Map<String, List<String>> buildGraph(
            String[] recipes, List<List<String>> ingredients,
            Map<String, Integer> indegree) {

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i < recipes.length; i++)
        {
            String r = recipes[i];

            for(String ingredient : ingredients.get(i))
            {
                map.putIfAbsent(ingredient, new ArrayList<>());

                map.get(ingredient).add(r);

                indegree.put(r, indegree.getOrDefault(r, 0)+1);
            }
        }

        return map;
    }

}