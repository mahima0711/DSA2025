class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for(int i =0 ; i<list1.length ;i++)
        {
           for(int j=0;j<list2.length;j++)
           {
            if(list1[i].equals(list2[j]))
            {
                int idx = i + j;

                if(idx < min)
                {
                    list.clear();
                    list.add(list1[i]);
                    min= idx;
                }
                else if(min == idx)
                {
                     list.add(list1[i]);
                }
            }
           }
        }

        String[] ans = new String[list.size()];

        for(int i=0;i<list.size();i++)
        {
            ans[i] = list.get(i);
        }

        return ans;
    }
}