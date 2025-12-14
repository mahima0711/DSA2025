class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i = 0;
        int j = 0;
        int start1 = 0;
        int end1 = 0;

        List<int[]> list = new ArrayList<>();
        if (firstList.length == 0 || secondList.length ==0)
            return new int[0][0];

        // if (secondList.length == 0)
        //     return secondList;

        while (i < firstList.length && j < secondList.length) {
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            start1 = firstList[i][0];
            end1 = firstList[i][1];

            if (start1 <= start2) {

                if (end1 >= start2) {
                    int s = Math.max(start1,start2);
                    int e =Math.min(end1, end2);

                    list.add(new int[] { s, e});
                }
            }
            else
            {
                if(end2 >= start1)
                {
                    int s = Math.max(start1,start2);
                    int e =Math.min(end1, end2);

                    list.add(new int[] { s, e});

                }

            }

            if(end1 <= end2)
            {
                i++;
            }
            else
                j++;
        }

        return list.toArray(new int[list.size()][]);
    }
}