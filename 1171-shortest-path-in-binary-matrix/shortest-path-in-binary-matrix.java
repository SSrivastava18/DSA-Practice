class Solution {

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

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] vis = new boolean[n][n];

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0, 1));

        vis[0][0] = true;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int r = curr.r;
            int c = curr.c;
            int dist = curr.dist;

            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            for (int nr = r - 1; nr <= r + 1; nr++) {

                for (int nc = c - 1; nc <= c + 1; nc++) {

                    if (nr >= 0 && nc >= 0 &&
                        nr < n && nc < n &&
                        !vis[nr][nc] &&
                        grid[nr][nc] == 0) {

                        vis[nr][nc] = true;

                        q.offer(new Pair(nr, nc, dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}