class Solution {
    public int mirrorDistance(int n) {
        
        int sum =0;

        int m = n;

        while(n!=0)
        {
            int k = n%10;
            sum = sum *10 + k;
            n=n/10;
        }

        return Math.abs(m-sum);
    }
}