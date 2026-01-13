class Solution {

    boolean canAllocatePile(int candies[], long k, int mid)
    {
        long count =0;

        for(int candie : candies)
        {
            count += candie/mid;

            if(count >= k)
            {
                return true;
            }
        }

        return false;
    }

    public int maximumCandies(int[] candies, long k) {

        long sum =0;

        for(int candie : candies)
        {
            sum += candie;
        }

        if(k>sum)
          return 0;
        
        int left = 1;
        int right = Integer.MAX_VALUE;

        for(int candie : candies)
        {
            right = Math.max(right, candie);
        }

        while(left < right)
        {
            int mid = left + (right - left +1)/2;

            if(canAllocatePile(candies, k, mid))
            {
                left = mid;
            }
            else
            {
                right = mid-1;
            }
        }
        return left;
    }
}