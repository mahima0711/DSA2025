import java.util.regex.*;
class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        HashSet<String> set = new HashSet<>();

        // Horizontal
        for(int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(board[i][j] == ' ') sb.append(".");
                else sb.append(board[i][j]);
            }
            set.addAll(Arrays.asList(sb.toString().split("#")));
			set.addAll(Arrays.asList(sb.reverse().toString().split("#")));
        }

        // Vertical
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m; j++) {
                if(board[j][i] == ' ') sb.append(".");
                else sb.append(board[j][i]);
            }
            set.addAll(Arrays.asList(sb.toString().split("#")));
			set.addAll(Arrays.asList(sb.reverse().toString().split("#")));
        }

        StringBuilder word_sb = new StringBuilder(word);
        for(String str: set) {
            Pattern p = Pattern.compile(str);
            //System.out.println("Set: "+str +" - pattern " +p);
            Matcher matcher = p.matcher(word);
            //System.out.println("Set: "+str +" - matcher " +matcher);
            //System.out.println(s);

            if(matcher.matches()) return true;
        }

        return false;
    }
}