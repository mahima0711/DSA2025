class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    List<Integer> list = new ArrayList<>();
                    long sum= (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                    }

                    if(sum < target)
                    left++;
                    else
                    right--;
                }
            }
        }

        return new ArrayList<>(ans);
    }
}