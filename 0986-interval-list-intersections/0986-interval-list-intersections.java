class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

       int i = 0;
        int j = 0;

        List<int[]> list = new ArrayList<>();

        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }

        while (i < firstList.length && j < secondList.length) {

            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            // Intersection check using a single formula
            int s = Math.max(start1, start2);
            int e = Math.min(end1, end2);

            if (s <= e) {
                list.add(new int[]{s, e});
            }

            // Move the pointer for the interval that ends first
            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}