class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int count[] = new int[n];

        long rooms[] = new long[n];

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        for(int i=0;i<meetings.length;i++)
        {
            int minIdx = 0;
            boolean isRoomAllocated = false;
            for(int j=0;j<rooms.length;j++)
            {
                if(meetings[i][0] >= rooms[j])
                {
                    rooms[j] = meetings[i][1];
                    count[j] += 1;
                    isRoomAllocated = true;
                    break;
                }

                if(rooms[j] < rooms[minIdx])
                {
                    minIdx = j;
                }
            }

            if(!isRoomAllocated)
            {
                rooms[minIdx] += meetings[i][1] - meetings[i][0];
                count[minIdx] += 1;
            }
        }

        //10^5
        //10^5
        //10^10
        // max int value - 2*10^9
        int maxRoomCountIdx =0;

         for(int i=0;i<n;i++)
        {
            if(count[i] > count[maxRoomCountIdx])
            maxRoomCountIdx =  i;
        }

        return maxRoomCountIdx;
    }
}