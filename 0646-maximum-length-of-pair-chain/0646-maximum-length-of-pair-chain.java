class Solution {
   Integer[] dp;
    public int solve(int[][] pairs, int i){
        if(dp[i]!=null) return dp[i];

        int ans = 1;
        for(int j=0; j<i; j++){
            if(pairs[j][1] < pairs[i][0]){
                int a = 1 + solve(pairs, j);
                ans = Math.max(ans, a);
            }
        }
        return dp[i] = ans;
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> {
            return a[1]-b[1]; // sort by right
        });

        // Simple LIS hi hai
        dp = new Integer[n];
        int max = 0;
        for(int i=0; i<n; i++){
            int a = solve(pairs, i);
            max = Math.max(max, a);
        }
        return max;
    }
}