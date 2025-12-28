class Solution {
    public int countNegatives(int[][] grid) {
        
       int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                // All elements in this column from the current row down are negative.
                count += (m - row);
                // Move to the previous column to find more negatives.
                col--;
            } else {
                // This element is non-negative, so no negatives in this row to the left.
                // Move to the next row.
                row++;
            }
        }
        return count;
    }
}