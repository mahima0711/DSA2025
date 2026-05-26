class Solution {
    public int numberOfSpecialChars(String word) {

        Set<Integer> set = new HashSet<>();

        for (char ch : word.toCharArray()) {
            set.add((int) ch);
        }

        int count = 0;

        for (int ascii : set) {

            if (ascii >= 'a' && ascii <= 'z') {

                if (set.contains(ascii - 32)) {
                    count++;
                }
            }
        }

        return count;
    }
}