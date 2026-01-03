class Solution {
    public int lengthOfLongestSubstring(String s) {
        

        int left=0;
        int right =0;
        int maxWindow =0;

        Map<Character, Integer> map = new HashMap<>();

        while(right < s.length())
        {
            char c= s.charAt(right);

            if(!map.containsKey(c))
            {
               map.put(c,1);
            }
            else
            {
                while(map.containsKey(c) && left <= right)
                {
                    map.remove(s.charAt(left));
                    left++;
                }
                map.put(c,1);
            }

            maxWindow = Math.max(maxWindow, right-left+1);

            right ++;
        }

        return maxWindow;
    }
}