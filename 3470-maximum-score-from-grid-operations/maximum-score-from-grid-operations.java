class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] pref = new long[n + 1][n + 1];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                pref[j + 1][i + 1] = pref[j + 1][i] + grid[i][j];
            }
        }

        long[][][] dp = new long[n + 1][n + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = dp[i][j][1] = -1;
            }
        }

        return solve(0, 0, 0, n, pref, dp);
    }

    private long solve(int col, int prevH, int isIncreasing, int n, long[][] pref, long[][][] dp) {
        if (col == n) return 0;
        if (dp[col][prevH][isIncreasing] != -1) return dp[col][prevH][isIncreasing];

        long res = 0;

        for (int currH = 0; currH <= n; currH++) {
            if (isIncreasing == 1) {
                if (currH > prevH) {
                    long score = pref[col][currH] - pref[col][prevH];
                    res = Math.max(res, score + solve(col + 1, currH, 1, n, pref, dp));
                } else {
                    long score = pref[col + 1][prevH] - pref[col + 1][currH];
                    res = Math.max(res, score + solve(col + 1, currH, 0, n, pref, dp));
                }
            } else {
                if (currH < prevH) {
                    long score = pref[col + 1][prevH] - pref[col + 1][currH];
                    res = Math.max(res, score + solve(col + 1, currH, 0, n, pref, dp));
                } else {
                    res = Math.max(res, solve(col + 1, currH, 1, n, pref, dp));
                }
            }
        }

        return dp[col][prevH][isIncreasing] = res;
    }
}