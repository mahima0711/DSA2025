class Solution {

    boolean canBloom(int bloomDay[], int m, int k, int mid)
    {
        int count=0;
        int bouquets = 0;

        for(int b : bloomDay)
        {
            if(b <= mid)
            {
                count++;

                if(count == k)
                {
                    bouquets++;
                    count=0;
                }
            }
            else
            {
                count=0;
            }
        }

        return bouquets>=m;

    }

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) return -1;
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int day: bloomDay)
        {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while(left < right)
        {
            int mid = left + (right - left)/2;

            if(canBloom(bloomDay, m, k, mid))
            {
                right = mid;
            }
            else
            {
                left = mid +1;
            }
        }

        return left;
    }
}