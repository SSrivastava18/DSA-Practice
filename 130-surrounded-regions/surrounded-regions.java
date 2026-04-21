class Solution {
    static int rows;
    static int cols;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { 
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O')
            return;

        board[r][c] = '#';

        for(int i = 0; i<4; i++){
            int nr = dr[i] + r;
            int nc = dc[i] + c;

            dfs(board, nr, nc);


        }

    }
}