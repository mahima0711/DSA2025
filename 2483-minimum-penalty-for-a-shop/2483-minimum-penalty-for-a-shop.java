class Solution {
    public int bestClosingTime(String customers) {
        
        int prefixSum =0;
        int suffixSum =0;
        int ans =0;
        int index=0;


        for(int i=0;i<customers.length();i++)
        {
            if(customers.charAt(i) == 'Y')
               suffixSum++;
        }

        if(suffixSum == 0)
        {
            return 0;
        }

        ans = suffixSum;

        for(int i=0;i<customers.length();i++)
        {
            if(customers.charAt(i) == 'N')
            {
                prefixSum++;
            }
            else
            {
                suffixSum--;
            }

            int min = prefixSum+suffixSum;

            if(ans > min)
            {
              ans = min;
              index = i+1;
            }
        }

        return index;
    }
}