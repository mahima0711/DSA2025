class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        StringBuilder str = new StringBuilder();

        generateSol(str, n, list);

        return list;
    }

    void generateSol(StringBuilder str, int n, List<String> list) {

        if(str.length() == 2*n) {
            if(isValid(str)) {
                list.add(str.toString());
            }

            return;
        }

        str.append("(");
        generateSol(str, n, list);
        str.deleteCharAt(str.length() - 1);

        str.append(")");
        generateSol(str, n, list);
        str.deleteCharAt(str.length() - 1);
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