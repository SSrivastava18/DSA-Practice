class Solution {
    int[][][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        dp = new int[n+1][n+1][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(dp[i][j][k], Integer.MIN_VALUE);
                }
            }
        }

        int ans = solve(0, 0, 0, 0, grid, n);
        return Math.max(0, ans);
    }

    public int solve(int r1, int c1, int r2, int c2, int[][] grid, int n) {

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != Integer.MIN_VALUE) {
            return dp[r1][c1][r2][c2];
        }

        int cherries = 0;

        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int op1 = solve(r1 + 1, c1, r2 + 1, c2, grid, n);
        int op2 = solve(r1, c1 + 1, r2, c2 + 1, grid, n);
        int op3 = solve(r1 + 1, c1, r2, c2 + 1, grid, n);
        int op4 = solve(r1, c1 + 1, r2 + 1, c2, grid, n);

        int best = Math.max(Math.max(op1, op2), Math.max(op3, op4));

        cherries += best;

        return dp[r1][c1][r2][c2] = cherries;
    }
}