class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        generate(0, ans, new ArrayList<>(), candidates, target);

        return ans;
    }

    void generate(int index,
                  List<List<Integer>> ans,
                  List<Integer> list,
                  int[] candidates,
                  int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length || target < 0)
            return;

        // include
        list.add(candidates[index]);
        generate(index + 1, ans, list, candidates,
                 target - candidates[index]);
        list.remove(list.size() - 1);

        // skip duplicates
        while (index + 1 < candidates.length &&
               candidates[index] == candidates[index + 1]) {
            index++;
        }

        // exclude
        generate(index + 1, ans, list, candidates, target);
    }
}
