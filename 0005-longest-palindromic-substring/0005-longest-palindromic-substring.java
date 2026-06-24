class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();

        int maxLength = 0;

        int startIdx = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(solve(i, j, s))
                {
                    if(j-i+1 > maxLength)
                    {
                        maxLength = j-i+1;
                        startIdx = i;
                    }
                }
            }
        }

        return s.substring(startIdx, startIdx + maxLength);
    }

    boolean solve(int i, int j, String s){

        if(i>=j)
        {
            return true;
        }

        if(s.charAt(i) == s.charAt(j))
        {
            return solve(i+1, j-1, s);
        }

        return false;
    }
}