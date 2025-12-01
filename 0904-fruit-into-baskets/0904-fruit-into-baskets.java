class Solution {
    public int totalFruit(int[] fruits) {
        
        int low =0;
        int maxLength =0;
        int len =0;
        int k=2;

        Map<Integer,Integer> map = new HashMap<>();

        for(int high=0;high<fruits.length;high++)
        {
           if(!map.containsKey(fruits[high]))
           {
             map.put(fruits[high], 1);

             while(map.size()>2)
             {
                map.put(fruits[low], map.get(fruits[low])-1);

                if(map.get(fruits[low])==0)
                {
                    map.remove(fruits[low]);
                }
                low++;
             }
           }
           else
           {
             map.put(fruits[high], map.get(fruits[high])+1);
           }

           len =high-low+1;
           maxLength = Math.max(maxLength,len);
        }

        return maxLength;
    }
}