class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        StringBuilder str = new StringBuilder();

        int open =0;
        int close =0;

        generateSol(str, n, list, open, close);

        return list;
    }

    void generateSol(StringBuilder str, int n, List<String> list, int open, int close) {

        if(str.length() == 2*n) {
            if(isValid(str)) {
                list.add(str.toString());
            }

            return;
        }

        if(open < n)
        {
        str.append("(");
        generateSol(str, n, list, open+1, close);
        str.deleteCharAt(str.length() - 1);
        }

        if(close<n)
        {
        str.append(")");
        generateSol(str, n, list, open, close+1);
        str.deleteCharAt(str.length() - 1);
        }
    }

    boolean isValid(StringBuilder str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}