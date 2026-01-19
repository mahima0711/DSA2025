class Solution {
    public int largestInteger(int num) {

        PriorityQueue<Integer> oddPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> evenPq = new PriorityQueue<>(Collections.reverseOrder());

        char[] arr = Integer.toString(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - '0') % 2 == 0) {
                evenPq.add(arr[i]-'0');
            } else {
                oddPq.add(arr[i]-'0');
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arr.length;i++)
        {
            if((arr[i]-'0') % 2 == 0)
            {
                sb.append(evenPq.poll());
            }
            else
            {
                sb.append(oddPq.poll());
            }
        }

        return Integer.parseInt(sb.toString());
    }
}