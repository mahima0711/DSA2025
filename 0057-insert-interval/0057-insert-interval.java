class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ar = new ArrayList<>();
        boolean insert = false;
        if (intervals.length == 0) {
            return new int[][] { { newInterval[0], newInterval[1] } };
        }

        for (int i = 0; i < n; i++) {
            int[] curr = intervals[i];
            if (insert == false && curr[0] >= newInterval[0]) {
                ar.add(newInterval);
                insert = true;
            }

            ar.add(intervals[i]);
        }

        if(insert ==false)
        {
            ar.add(newInterval);
        }

        int[][] arr = ar.toArray(new int[ar.size()][]);

        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }

        List<int[]> merged = new ArrayList<>();

        int start1 = arr[0][0];
        int end1 = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            int start2 = arr[i][0];
            int end2 = arr[i][1];
            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
                continue;
            }
            merged.add(new int[] { start1, end1 });
            start1 = start2;
            end1 = end2;

        }

        merged.add(new int[] { start1, end1 });

        return merged.toArray(new int[merged.size()][]);

    }
}