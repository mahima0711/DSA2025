class Solution {

    boolean canDistribute(int q[], int n, int mid)
    {
        int minProduct =0;

        for(int i: q)
        {
                minProduct+=(i+mid-1)/mid;
        }

        return minProduct <=n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        
        int left =1;
        int right =Integer.MIN_VALUE;

        for(int q : quantities)
        {
            right = Math.max(right, q);
        }

        while(left < right)
        {
            int mid = left + (right - left)/2;

            if(canDistribute(quantities, n, mid))
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