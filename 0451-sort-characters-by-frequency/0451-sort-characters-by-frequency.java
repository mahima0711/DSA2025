class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b), map.get(a)));

        for(Character c : map.keySet())
        {
            pq.add(c);
        }

        StringBuilder str= new StringBuilder();

        while(pq.size() > 0)
        {
            if(map.containsKey(pq.peek()))
            {
                int m = map.get(pq.peek());
                for(int i=0;i<m;i++)
                {
                    str.append(pq.peek());
                }
                pq.poll();
            }
        }

        return str.toString();

    }
}