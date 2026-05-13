class Solution {

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (solve(i, j, 0, board, word, vis)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean solve(int i, int j,
                  int idx,
                  char[][] board,
                  String word,
                  boolean[][] vis) {

        if (idx == word.length()) {
            return true;
        }

        int n = board.length;
        int m = board[0].length;

        if (i < 0 || j < 0 ||
            i >= n || j >= m ||
            vis[i][j] ||
            board[i][j] != word.charAt(idx)) {

            return false;
        }

        vis[i][j] = true;

        boolean ans =
                solve(i + 1, j, idx + 1, board, word, vis) ||
                solve(i - 1, j, idx + 1, board, word, vis) ||
                solve(i, j + 1, idx + 1, board, word, vis) ||
                solve(i, j - 1, idx + 1, board, word, vis);

        vis[i][j] = false;

        return ans;
    }
}