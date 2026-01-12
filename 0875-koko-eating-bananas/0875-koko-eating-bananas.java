class Solution {

    boolean canEat(int[] piles, int hour, int k)
    {
        int curr =0;
        int requiredHour =0;

        for(int pile : piles)
        {
           requiredHour += (pile + k - 1) / k;
        }

        return requiredHour <= hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int left =1;
        int right =0;

        for(int p : piles)
        {
            right = Math.max(right,p);
        }

        while(left < right)
        {
            int mid = left + (right - left)/2;

            if(canEat(piles, h, mid))
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }

        return left;
    }
}