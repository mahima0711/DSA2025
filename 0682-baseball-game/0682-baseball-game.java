class Solution {
    public int calPoints(String[] operations) {
  Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {
                int top1 = stack.pop();
                int top2 = stack.peek();
                stack.push(top1);              // restore
                stack.push(top1 + top2);

            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);

            } else if (op.equals("C")) {
                stack.pop();

            } else {
                // op is a number
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;

    }
}