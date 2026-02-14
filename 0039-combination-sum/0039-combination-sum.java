class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        generate(0, ans, list, candidates, target);

        return ans;
    }

    void generate(int index, List<List<Integer>> ans, List<Integer> list, int[] candidates, int target)
    {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length || target < 0)
            return;


        list.add(candidates[index]);
        generate(index, ans, list, candidates, target - candidates[index]);

        list.remove(list.size() -1);       
        generate(index + 1, ans, list, candidates, target);

    }

}