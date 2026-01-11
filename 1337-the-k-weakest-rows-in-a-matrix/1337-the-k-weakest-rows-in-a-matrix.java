class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int[][] ans = new int[mat.length][2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int low = 0;
            int high = mat[i].length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (mat[i][mid] == 1) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            ans[i][0] = i;
            ans[i][1] = low;
        }

        Arrays.sort(ans, (a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = ans[i][0];
        }

        return result;

    }
}