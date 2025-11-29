class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> map =new HashMap<>();
            List<Integer> list = new ArrayList<>();
           for(int k=0;k<nums1.length;k++)
           {
            map.put(nums1[k], map.getOrDefault(nums1[k], 0) + 1);
           }
           
           for(int num:nums2)
           {
            if(map.containsKey(num)){
            list.add(num);
            map.remove(num);
            }
           }
              
              int arr[] = new int[list.size()];
              for(int l=0;l<arr.length;l++)
              {
                arr[l]=list.get(l);
              }
 
           return arr;
    }
}