class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        List<Integer> l = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        generate(nums, ans, l, used);

        return ans;
    }

    void generate(int[] nums, List<List<Integer>> list, List<Integer> l, boolean[] used) {

        if (l.size() == nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;
            l.add(nums[i]);
            used[i] = true;
            generate(nums, list, l, used);
            used[i] = false;
            l.remove(l.size() - 1);

        }
    }
}