class Solution {
    public int longestBalanced(String s) {

        int ans = 1;

        for(int i=0;i<s.length()-1;i++)
        {
            int[] freq = new int[26];
            int maxFreq =1;
            int distinct =0;   
            for(int j=i;j<s.length();j++)
            {
                freq[s.charAt(j) - 'a']++;
                if(freq[s.charAt(j) - 'a'] == 1)
                {
                    distinct++;
                }

                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'a']);
                if((j-i+1) == maxFreq * distinct)
                {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }

        return ans;
    }
}