class Pair{

    char c;
    int val;

    Pair(char c, int val)
    {
        this.c = c;
        this.val= val;
    }
}

class Solution {
    public String reorganizeString(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val - a.val);

        for(Map.Entry<Character, Integer> m : map.entrySet())
        {
            pq.add(new Pair(m.getKey(), m.getValue()));
        }

        StringBuilder str = new StringBuilder();
        Pair prev =null;

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            
            str.append(p.c);
            p.val--;

            if(prev!=null && prev.val >0)
            {
                pq.add(prev);
            }

            prev =p;
        }

        if (str.length() != s.length()) {
            return "";
        }

        return str.toString();
   }
}