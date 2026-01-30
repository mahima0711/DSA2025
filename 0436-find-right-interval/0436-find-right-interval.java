class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int n=intervals.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++)
        {
            ans[i] = -1;
        }

        for(int i=0;i<n;i++)
        {
            int minIdx = -1;
            int minVal=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(intervals[j][0] >= intervals[i][1])
                {
                    if(intervals[j][0] <= minVal)
                    {
                        ans[i] = j;
                        minVal = intervals[j][0];
                    }
                }
                
            }
        }

        return ans;
    }
}