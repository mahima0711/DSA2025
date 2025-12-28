class Solution {

    public int calculateNextIdx(int[] nums, int curr) {
        int next = curr;

        int seq = nums[curr];

        if (seq > 0) {
            next = (next + seq) % nums.length;
        } else {
            int mod = seq % nums.length;
            int forward = nums.length + mod;

            next = (curr + forward) % nums.length;
        }

        return next;
    }

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            boolean isPos = nums[i] > 0;

            int curr = i;

            while (true) {

                int next = calculateNextIdx(nums, curr);
                if (isPos) {
                    if (nums[next] < 0)
                    {
                        break;
                    }else
                    {
                    if(set.contains(next)) {
                        //cycle is there

                        //k>1
                        if (curr != next) {
                            return true;
                        } else {
                            break;
                        }
                    }

                    set.add(next);
                    }

                } else {
                    if (nums[next] > 0)
                    {
                        break;
                        
                    } else{ if(set.contains(next)) {
                        //cycle is there

                        //k>1
                        if (curr != next) {
                            return true;
                        } else {
                            break;
                        }
                    }

                    set.add(next);
                    }
                }

                 curr = next; 
            }
        }

        return false;
    }
}