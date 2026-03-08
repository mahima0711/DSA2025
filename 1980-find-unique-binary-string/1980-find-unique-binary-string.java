class Solution {

    String find(List<String> list, String[] nums)
    {
        for(int i=0; i<list.size();i++)
        {
            boolean contains = false;
            for(int j=0;j<nums.length;j++)
            {
                if(list.get(i).equals(nums[j]))
                {
                    contains = true;
                }
            }

            if(!contains)
            {
                return list.get(i);
            }
        }

        return "";
    }

    public String findDifferentBinaryString(String[] nums) {
        
        List<String> list = new ArrayList<>();

        StringBuilder str = new StringBuilder();

        int length = nums[0].length();
        
        generate(list, str, length);

        String s = find(list, nums);

        return s;
    }
    
    void generate(List<String> list, StringBuilder str, int length)
    {
        if(str.length() == length)
        {
            list.add(str.toString());
            return;
        }

        str.append('0');

        generate(list, str, length);

        str.deleteCharAt(str.length()-1);

        str.append('1');

        generate(list, str, length);

        str.deleteCharAt(str.length()-1);

    }
}