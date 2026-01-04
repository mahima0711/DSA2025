class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int count=0;
        int left =0;
        int sum=0;

        for(int right =0;right<arr.length;right++)
        {
            sum = sum +arr[right];

            while(right - left +1 > k)
            {
                sum = sum - arr[left];
                left++;
            }

            if(right - left +1 == k)
            {
                int avg = sum / k;
                if(avg >= threshold)
                {
                    count++;
                }
            }

        }

        return count;
    }
}