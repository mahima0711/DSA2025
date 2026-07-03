class Solution {
    public int findContentChildren(int[] g, int[] s) {

        int ans =0;

        Arrays.sort(g);

        Arrays.sort(s);

        int m = g.length;
        int n = s.length;

        int i=0;
        int j=0;

        while(i<n && j<m)
        {
            if(s[i]>=g[j])
            {
                ans++;
                i++;
                j++;
            }
            else
            {
                i++;
            }

        }

        return ans;

    }
}