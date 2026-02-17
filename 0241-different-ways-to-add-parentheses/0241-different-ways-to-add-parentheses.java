class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
    }

    public List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '*' || ch == '-') {
                List<Integer> left = solve(s.substring(0, i));
                List<Integer> right = solve(s.substring(i + 1));

                for (int x : left) {
                    for (int y : right) {
                        if (ch == '+') {
                            result.add(x + y);
                        } else if (ch == '-') {
                            result.add(x - y);
                        } else if (ch == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }
}