class Solution {
    int MOD = 1000000007;
    int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(m, n, startRow, startColumn, maxMove);
    }

    public int solve(int m, int n, int i, int j, int moves) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }

        if (moves == 0) {
            return 0;
        }

        if (dp[i][j][moves] != -1) {
            return dp[i][j][moves];
        }

        int up = solve(m, n, i - 1, j, moves - 1);
        int down = solve(m, n, i + 1, j, moves - 1);
        int left = solve(m, n, i, j - 1, moves - 1);
        int right = solve(m, n, i, j + 1, moves - 1);

        dp[i][j][moves] = ((up + down) % MOD + (left + right) % MOD) % MOD;

        return dp[i][j][moves];
    }
}