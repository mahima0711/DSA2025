class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder merged = new StringBuilder();
        int count=0;
        if(word1.length()>word2.length())
        {
            count =word2.length();
        }
        else 
        {
            count = word1.length();
        }

        for(int i=0; i<count;i++)
        {
           merged.append(word1.charAt(i)).append(word2.charAt(i));
        }
         
         if(count < word1.length())
          {
            for(int i=count;i<word1.length();i++)
              merged.append(word1.charAt(i));
          }

         if(count < word2.length())
          {
            for(int i=count;i<word2.length();i++)
              merged.append(word2.charAt(i));
          }
        
        return merged.toString();

    }
}