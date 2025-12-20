class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] arr = path.split("/");

        // for(int i=0;i<arr.length;i++)
        // {
        //     System.out.println(arr[i]);
        // }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (arr[i].equals(".") || arr[i].isEmpty()) {
                //stack.push(arr[i]);
                continue;
            } else {
                stack.push(arr[i]);
            }
        }

        int length = stack.size();
        StringBuilder str = new StringBuilder();

        if (stack.isEmpty())
            return "/";

        for (String ans : stack) {
            str.append("/").append(ans);

        }
        return str.toString();

    }
}