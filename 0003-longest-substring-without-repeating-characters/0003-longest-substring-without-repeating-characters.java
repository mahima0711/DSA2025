class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int low=0;
        
        Map<Character, Integer> map = new HashMap<>();

        int maxLength=0;
        int len=0;

        for(int high =0; high<s.length();high++)
        {
            if(!map.containsKey(s.charAt(high)))
            {
                map.put(s.charAt(high), high);
            }
            else
            {
                if(map.get(s.charAt(high))>=low)
                {
                    low = map.get(s.charAt(high))+1;
                }

                map.put(s.charAt(high),high);
            }

            len = high-low+1;
            maxLength = Math.max(maxLength,len);
        }

        return maxLength;
    }
}