class Solution {
    public String minRemoveToMakeValid(String s) {

        int count1 = 0;
        int count2 = 0;
        Stack<Character> stack = new Stack<>();

        // for(int i=0;i<s.length();i++)
        // {
        //     if(s.charAt(i) == '(')  
        //        count1++;
        //     else
        //        count2++;
        //  }
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                count2++;
                if (count1 >= count2) {
                    str.append(s.charAt(i));
                } else {
                    count2--;
                }
            } else if (s.charAt(i) == '(') {
                count1++;
                str.append(s.charAt(i));
            } else {
                str.append(s.charAt(i));
            }
        }

        count1 = 0;
        count2 = 0;

        StringBuilder ans = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                count1++;
                if (count2 >= count1) {
                    ans.append(str.charAt(i));
                } else {
                    count1--;
                }
            } else if (str.charAt(i) == ')') {
                count2++;
                ans.append(str.charAt(i));
            } else {
                ans.append(str.charAt(i));
            }
        }

        return ans.reverse().toString();
    }
}