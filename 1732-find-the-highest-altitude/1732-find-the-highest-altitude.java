class Solution {
    public int largestAltitude(int[] gain) {
        
        int num =0;

        int i=0; 
        int n = gain.length;
        int ans[] = new int[n+1];

        ans[0] = num;

        while(i<n)
        {
            num = num + gain[i];
            ans[i+1] = num;
            i++;
        }

        int maxNum = 0;

        for(int j=0;j<n+1;j++)
        {
            if(ans[j] > maxNum)
            {
                maxNum = ans[j];
            }
        }

        return maxNum;
    }
}