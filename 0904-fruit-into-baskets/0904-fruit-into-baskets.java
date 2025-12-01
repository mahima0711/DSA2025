class Solution {
    public int totalFruit(int[] fruits) {
        
        int low =0;
        int maxLength =0;
        int len =0;
        int k=2;

        Map<Integer,Integer> map = new HashMap<>();

        for(int high=0;high<fruits.length;high++)
        {
             map.put(fruits[high], map.getOrDefault(fruits[high],0)+1);

             while(map.size()>2)
             {
                map.put(fruits[low], map.get(fruits[low])-1);

                if(map.get(fruits[low])==0)
                {
                    map.remove(fruits[low]);
                }
                low++;
             
           }

           len =high-low+1;
           maxLength = Math.max(maxLength,len);
        }

        return maxLength;
    }
}