class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();

        int sum =0;

        for(int i=0; i <tokens.length;i++)
        {
            if(tokens[i].equals("*"))
            {
                int second = stack.pop();
                int first = stack.pop();
                int result = (first*second);
                stack.push(result);
            }
           else if(tokens[i].equals("+"))
           {

                int second = stack.pop();
                int first = stack.pop();
                int result = first+second;
                stack.push(result);

           }else if(tokens[i].equals("/"))
           {
                int second = stack.pop();

                int first = stack.pop();

                int result = first / second;
                stack.push(result);
           }else if(tokens[i].equals("-"))
            {
                int second = stack.pop();

                int first = stack.pop();

                int result = first - second;
                stack.push(result);
            }else
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}