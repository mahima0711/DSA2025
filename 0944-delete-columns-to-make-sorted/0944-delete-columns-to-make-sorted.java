class Solution {
    public int minDeletionSize(String[] strs) {

        //int[][] matrix = new int[strs[0].length()][strs.length];
        int count = 0;
        int len = strs[0].length();
        int i = 0;

        for (int j = 0; j < len; j++) {

            while (i < strs.length-1) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    break;
                }
                i++;
            }
            i = 0;
        }

        return count;

    }
}