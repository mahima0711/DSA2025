class Solution {

    boolean canShip(int[] weights, int days, int mid)
    {
        int currentLoad = 0;
        int requiredDays = 1;

        for(int w : weights)
        {
            int load = currentLoad + w;

            if(load > mid)
            {
                requiredDays++;
                currentLoad =0;
            }

            currentLoad +=w;
        }

        return requiredDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int left =0;
        int right=0;

        for(int w : weights)
        {
            left = Math.max(left,w);
            right+=w;
        }

        while(left < right)
        {
            int mid = left + (right-left)/2;
            
            if(canShip(weights, days, mid))
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