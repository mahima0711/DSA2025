class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        int sum = 0;

        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }

        Arrays.sort(capacity);
        int count=0;

        for(int j=capacity.length-1;j >=0;j--)
        {
             count += capacity[j];

            if(count >= sum)
            {
               return capacity.length -j;
            }
        }

        return -1;

    }
}