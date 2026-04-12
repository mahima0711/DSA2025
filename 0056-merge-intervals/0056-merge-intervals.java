class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0)
        {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i=1;i<intervals.length;i++)
        {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 >= start2)
            {
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }
             
            //int[] arr={start1,end1};
            merged.add(new int[]{start1, end1});

            start1 = start2;
            end1 = end2;
        }

        //int[] arr={start1,end1};
        merged.add(new int[]{start1, end1});
        return merged.toArray(new int[merged.size()][]);

        // if(intervals.length == 0)
        // {
        //     return new int[0][0];
        // }
        // Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        // List<int[]> merged = new ArrayList<>();
        // merged.add(intervals[0]);

        // for(int i=1;i<intervals.length;i++)
        // {
        //     int last[] = merged.get(merged.size()-1);
        //     int curr[] = intervals[i];

        //     if(last[1] >= curr[0])
        //     {
        //         last[1] = Math.max(last[1],curr[1]);
        //     }
        //     else
        //     {
        //         merged.add(curr);
        //     }
        // }

        // return merged.toArray(new int [merged.size()][]);


    }
}