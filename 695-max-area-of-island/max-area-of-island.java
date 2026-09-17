class Solution {

    int rows, cols;
    static int[] dr= {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area = dfs(i, j, grid, vis);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] vis) {

        if (r < 0 || c < 0 || r >= rows || c >= cols ||
            grid[r][c] == 0 || vis[r][c]) {
            return 0;
        }

        vis[r][c] = true;

        int area = 1;

        for(int k = 0; k<4; k++){
            int nr = r +dr[k];
            int nc = c+dc[k];
            area+=dfs(nr,nc, grid, vis);
        }

        return area;
    }
}
