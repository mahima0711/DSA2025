class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l = new ArrayList<>();

        generate(0, nums, list, l);

        return list;
    }

    void generate(int index, int[] nums, List<List<Integer>> list, List<Integer> l)
    {
        if(index == nums.length)
        {
            list.add(new ArrayList<>(l));
            return;
        }

        l.add(nums[index]);
        generate(index+1, nums, list, l);
        l.remove(l.size()-1);

        generate(index+1, nums, list, l);
    }
}