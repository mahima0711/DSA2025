class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int diff[] = new int[1001];

        for(int[] trip : trips)
        {
            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];

            diff[start] = diff[start] + passenger;
            diff[end] = diff[end] - passenger;
        }

        int curr =0;

        for(int i=0;i<diff.length;i++)
        {
            curr = curr + diff[i];
            if(curr > capacity)
            {
                return false;
            }
        }

        return true;
    }
}