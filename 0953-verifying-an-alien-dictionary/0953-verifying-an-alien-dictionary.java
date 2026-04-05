class Solution {
    public boolean isAlienSorted(String[] words, String order) {
 int[] orderAlpha = new int[26];
        Arrays.fill(orderAlpha, Integer.MAX_VALUE);
        for (int i = 0; i < order.length(); i++) {
            orderAlpha[order.charAt(i) - 'a'] = i; 
        }
        
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i-1]; 
            String word2 = words[i]; 
            
            int minLen = Math.min(word1.length(), word2.length());
            boolean foundDiff = false;
            for (int j = 0; j < minLen; j++) {
                int rank1 = orderAlpha[word1.charAt(j) - 'a'];
                int rank2 = orderAlpha[word2.charAt(j) - 'a'];
                
                if (rank1 > rank2) return false;     // word1 > word2: unsorted
                if (rank1 < rank2) {                 // word1 < word2: good
                    foundDiff = true;
                    break;
                }
            }
            
            // If no difference found and word1 longer: prefix violation
            if (!foundDiff && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
        
    }
}