class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->  Integer.compare(y.value, x.value));

        for(int i=0;i<score.length;i++)
        {
            pq.add(new Pair(score[i], i));
        }

        String[] ans = new String[score.length];

        int count =0;

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();

            int idx = p.index;
            count++;

            if(count == 1)
            {
                ans[idx] = "Gold Medal";
            }
            else if(count == 2)
            {
                ans[idx] = "Silver Medal";
            }
            else if(count == 3)
            {
                ans[idx] = "Bronze Medal";
            }
            else
            {
                ans[idx] = String.valueOf(count);
            }

        }

        return ans;
    }
}

class Pair{

    int value;
    int index;

    Pair(int value, int index)
    {
        this.value = value;
        this.index = index;
    }
}