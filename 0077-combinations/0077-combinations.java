class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        //Set<List<Integer>> set = new HashSet<>();

        generate(1, n, k, ans, list);

        return ans;
    }

    void generate(int index, int num, int k, List<List<Integer>> ans, List<Integer> list) {
        if (index > num) {
            if (list.size() == k) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(index);
        generate(index + 1, num, k, ans, list);
        list.remove(list.size() - 1);
        generate(index + 1, num, k, ans, list);
    }
}