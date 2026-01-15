class Solution {

    public int minGroups(int[][] intervals) {
        
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<intervals.length;i++)
        {
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0],0)+1);

            //[start,end] both are inclusive so add 1
            map.put(intervals[i][1]+1, map.getOrDefault(intervals[i][1]+ 1,0)-1);
        }

        int curr=0;
        int maxValue=0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            curr += entry.getValue();

            maxValue = Math.max(maxValue, curr);
        }

        return maxValue;
    }
}