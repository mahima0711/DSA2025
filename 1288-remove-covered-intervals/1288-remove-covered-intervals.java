class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (start1 <= start2 && end1 >= end2) {

                end1 = Math.max(end1, end2);
                count++;
            } else {
                start1 = start2;
                end1 = end2;
            }

        }

        return intervals.length - count;
    }
}