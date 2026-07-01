class Solution {
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1}; 
    static int row;
    static int col;

    static class Pair {
        int r;
        int c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;

        boolean[][] vis = new boolean[row][col];
        int component = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    bfs(i, j, vis, grid);
                    component++;
                }
            }
        }

        return component;
    }

    public static void bfs(int i, int j, boolean[][] vis, char[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int R = curr.r;
            int C = curr.c;

            for (int k = 0; k < 4; k++) {
                int nr = R + dr[k];
                int nc = C + dc[k];

                if (nr >= 0 && nc >= 0 && nr < row && nc < col &&
                        !vis[nr][nc] && grid[nr][nc] == '1') {

                    vis[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
    }
}
