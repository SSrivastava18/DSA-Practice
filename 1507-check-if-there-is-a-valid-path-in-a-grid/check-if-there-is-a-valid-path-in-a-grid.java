class Solution {

    static int[] dr = {-1, 1, 0, 0}; // up, down, left, right
    static int[] dc = {0, 0, -1, 1};

    class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.r == m - 1 && cur.c == n - 1) return true;

            for (int dir = 0; dir < 4; dir++) {

                if (!canMove(grid[cur.r][cur.c], dir)) continue;

                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc])
                    continue;

                int opposite = getOpposite(dir);

                if (canMove(grid[nr][nc], opposite)) {
                    vis[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return false;
    }

    boolean canMove(int type, int dir) {

        if (type == 1) return dir == 2 || dir == 3; // left right
        if (type == 2) return dir == 0 || dir == 1; // up down
        if (type == 3) return dir == 2 || dir == 1; // left down
        if (type == 4) return dir == 3 || dir == 1; // right down
        if (type == 5) return dir == 2 || dir == 0; // left up
        return dir == 3 || dir == 0; // type 6 right up
    }

    int getOpposite(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }
}