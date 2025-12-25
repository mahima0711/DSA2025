class Solution {
    public String reverseWords(String s) {
        
        String str[] = s.trim().split("\\s+");
        StringBuilder c = new StringBuilder();
        for(int i=0;i<str.length;i++)
         System.out.println(str[i]);
        for(int i=str.length-1;i>=0;i--)
        {
            if(i>0)
            {
               c.append(str[i]);
               c.append(" ");
            
            }else
            {
                c.append(str[i]);
            }
        }

        return c.toString();
    }
}