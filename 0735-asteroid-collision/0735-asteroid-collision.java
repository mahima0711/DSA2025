class Solution {
    public int[] asteroidCollision(int[] asteroids) {

         Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {

            boolean alive = true;

            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {

                if (stack.peek() < Math.abs(a)) {
                    stack.pop();          // top explodes → continue checking
                    continue;
                } 
                else if (stack.peek() == Math.abs(a)) {
                    stack.pop();          // both explode
                }

                alive = false;           // current dies
                break;
            }

            if (alive) {
                stack.push(a);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}