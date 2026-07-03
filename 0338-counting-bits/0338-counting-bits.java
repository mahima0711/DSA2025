class Solution {
    public int[] countBits(int n) {

        int ans[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = i;

            if(num%2 == 0)
            {
                ans[i] = ans[i/2];
            }else
            {
                ans[i] = ans[i/2]+1;
            }
        }
        return ans;
    }
}