class Solution {
    public String longestCommonPrefix(String[] strs) {
         StringBuilder sb = new StringBuilder(strs[0]);
        for(int i=1; i<strs.length; i++){
            String s = strs[i];

            // Match curr string with previous answer
            StringBuilder ans = new StringBuilder();
            for(int j=0; j<Math.min(sb.length(), s.length()); j++){
                if(sb.charAt(j)==s.charAt(j)){
                    ans.append(s.charAt(j));
                }else{
                    break;
                }
            }
            sb = ans; // update ans (matched prefix)
        }
        return sb.toString(); // ans
    }
}