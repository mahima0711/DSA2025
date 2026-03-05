class Solution {
    public int minOperations(String s) {
        
         int n = s.length();

        //assuing final string start with 0 ..01010101
        //0 is at even places 
        int cnt1 = 0, cnt2 = 0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                if(s.charAt(i)=='1')
                cnt1++;
            }
            else
            {
                if(s.charAt(i)=='0')
                cnt1++;
            }
        }
         //assuing final string start with 1 ..1010101
        //1 is at even places 
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                if(s.charAt(i)=='0')
                cnt2++;
            }
            else
            {
                if(s.charAt(i)=='1')
                cnt2++;
            }
        }

        return Math.min(cnt1,cnt2);
    }
}