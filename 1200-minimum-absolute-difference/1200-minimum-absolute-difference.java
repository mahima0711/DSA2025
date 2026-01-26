class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        int val = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            val = Math.min(val, arr[i] - arr[i - 1]);
        }

        int i=0;
        int j=i+1;

        while(j<arr.length)
        {
            if(arr[j] - arr[i] == val)
            {
              List<Integer> list = new ArrayList<>();
              list.add(arr[i]);
              list.add(arr[j]);
              ans.add(list);
            }
            i++;
            j++;
        }

        return ans;

    }
}