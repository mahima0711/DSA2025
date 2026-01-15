class MyCalendarThree {

    TreeMap<Integer, Integer> treemap;

    public MyCalendarThree() {
        treemap = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        
            treemap.put(startTime, treemap.getOrDefault(startTime,0)+1);
            treemap.put(endTime, treemap.getOrDefault(endTime,0)-1);
        
        int curr=0;
        int maxroom =0;
        
        for(Map.Entry<Integer,Integer> entry : treemap.entrySet())
        {
            curr += entry.getValue();
            maxroom = Math.max(maxroom, curr);
        }
        
        return maxroom;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */