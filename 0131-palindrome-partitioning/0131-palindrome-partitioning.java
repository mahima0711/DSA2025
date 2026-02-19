class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        List<String> list = new ArrayList<>();

        backTrack(s, 0, ans, list);

        return ans;
    }

    void backTrack(String s, int index, List<List<String>> ans, List<String> list) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                backTrack(s, i + 1, ans, list);
                list.remove(list.size() - 1);

            }
        }
    }

    boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start) != s.charAt(end))
               return false;
            start++;
            end--;
        }

        return true;
    }
}