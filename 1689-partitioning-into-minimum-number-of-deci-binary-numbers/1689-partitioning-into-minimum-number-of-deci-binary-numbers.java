class Solution {
    public int minPartitions(String n) {

        int maxNum =0;
        for(int i=0;i<n.length();i++)
        {
            int k = n.charAt(i) - '0';

            maxNum = Math.max(maxNum, k);
        }

        return maxNum;
    }
}