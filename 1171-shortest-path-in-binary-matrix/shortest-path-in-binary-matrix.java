class Solution {

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Pair {

        int r;
        int c;
        int dist;

        Pair(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        boolean[][] vis = new boolean[row][col];

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0, 1));

        vis[0][0] = true;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int r = curr.r;
            int c = curr.c;
            int dist = curr.dist;

            if (r == row - 1 && c == col - 1) {
                return dist;
            }

            for (int k = 0; k < 8; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 &&
                    nc >= 0 &&
                    nr < row &&
                    nc < col &&
                    !vis[nr][nc] &&
                    grid[nr][nc] == 0) {

                    vis[nr][nc] = true;

                    q.offer(new Pair(nr, nc, dist + 1));
                }
            }
        }

        return -1;
    }
}