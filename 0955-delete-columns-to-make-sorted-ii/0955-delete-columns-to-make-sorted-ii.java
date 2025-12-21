class Solution {
    public int minDeletionSize(String[] strs) {
        
        int rows = strs.length;
        int cols = strs[0].length();
        int deletions = 0;

        // sorted[i] = true means strs[i] < strs[i+1] is already confirmed
        boolean[] sorted = new boolean[rows - 1];

        for (int col = 0; col < cols; col++) {

            boolean needDelete = false;

            // Check if this column breaks lexicographic order
            for (int i = 0; i < rows - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    needDelete = true;
                    break;
                }
            }

            // ❌ Column breaks → delete it
            if (needDelete) {
                deletions++;
                continue;
            }

            // Otherwise this column helps confirm some order relations
            for (int i = 0; i < rows - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    sorted[i] = true;   // this pair is now permanently sorted
                }
            }

            // Optimization: if all pairs sorted → stop early
            boolean done = true;
            for (boolean b : sorted) {
                if (!b) {
                    done = false;
                    break;
                }
            }
            if (done) break;
        }

        return deletions;
    }
}