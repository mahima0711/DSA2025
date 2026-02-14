class Solution {
    public List<String> letterCombinations(String digits) {

         List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder str = new StringBuilder();

        List<String> l = new ArrayList<>();

        generate(0,digits, list, str, map);

        return list;

    }

    void generate(int index, String digits, List<String> list, StringBuilder str, Map<Character, String> map)
    {
        if(index == digits.length())
        {
            list.add(str.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));

        for(int i=0;i<letters.length();i++)
        {
               str.append(letters.charAt(i));

               generate(index+1, digits, list, str, map);

               str.deleteCharAt(str.length()-1);
        }
    }
}