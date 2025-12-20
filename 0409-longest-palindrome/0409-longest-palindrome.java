class Solution {
    public int longestPalindrome(String s) {
        
          int[] freq = new int[128];   // covers all ASCII chars
        
        for(char c : s.toCharArray()){
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for(int count : freq){
            if(count % 2 == 0){
                length += count;          // use all even counts
            } else {
                length += count - 1;      // use the largest even part
                hasOdd = true;            // remember we have a char for center
            }
        }

        return hasOdd ? length + 1 : length;
    }
}