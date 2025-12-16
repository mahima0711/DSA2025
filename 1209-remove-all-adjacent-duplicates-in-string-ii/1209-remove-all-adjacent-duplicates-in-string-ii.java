class Solution {

    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public char getChar() {
            return this.ch;
        }

        public int getCount() {
            return this.count;
        }
    }

    public String removeDuplicates(String s, int k) {

        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (!stack.empty() && s.charAt(i) == stack.peek().getChar()) {
                int count = stack.peek().getCount()+1;
                stack.pop();
                if (count != k) {
                    stack.push(new Pair(s.charAt(i), count));
                }
            } else if (stack.empty() || s.charAt(i) != stack.peek().getChar()) {

                stack.push(new Pair(s.charAt(i), 1));

            }

        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int i = 0; i < p.getCount(); i++) {
                result.append(p.getChar());
            }
        }
        return result.reverse().toString();
    }
}