class Solution {
    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j=0;
        boolean flag=false;
        if(s.length()==0)
        return true;

        while(i<s.length()&&j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
                flag =true;
            }
            else
            {
                j++;
                flag =false;
            }
        }

        if(i!=s.length())
           return false;

        return flag;
    }
}