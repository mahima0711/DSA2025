class Solution {
    public long minimumSteps(String s) {  

      long ones = 0;
        long swaps = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else { 
                swaps += ones;
            }
        }

        return swaps;
    }
}