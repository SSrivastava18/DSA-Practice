class Solution {
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, m - 1, grid, n, m);
    }

    public int solve(int row, int c1, int c2, int[][] grid, int n, int m) {

        if (c1 < 0 || c2 < 0 || c1 >= m || c2 >= m) {
            return Integer.MIN_VALUE;
        }

        if (row == n - 1) {
            if (c1 == c2) return grid[row][c1];
            return grid[row][c1] + grid[row][c2];
        }

        if (dp[row][c1][c2] != -1) {
            return dp[row][c1][c2];
        }

        int cherries = 0;

        if (c1 == c2) {
            cherries = grid[row][c1];
        } else {
            cherries = grid[row][c1] + grid[row][c2];
        }

        int maxNext = 0;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int val = solve(row + 1, c1 + d1, c2 + d2, grid, n, m);
                maxNext = Math.max(maxNext, val);
            }
        }

        return dp[row][c1][c2] = cherries + maxNext;
    }
}