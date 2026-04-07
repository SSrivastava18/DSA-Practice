class Solution {
    int MOD = 1000000007;
    int[][][] dp;
    static int[] row = {-1, 1, 0, 0};
    static int[] col = {0, 0, -1, 1};

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

        int ans = 0;

        for (int d = 0; d < 4; d++) {
            int newRow = i + row[d];
            int newCol = j + col[d];

            ans = (ans + solve(m, n, newRow, newCol, moves - 1)) % MOD;
        }

        dp[i][j][moves] = ans;
        return ans;
    }
}