class Solution {
    int m, n;
    int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, dungeon);
    }

    public int solve(int i, int j, int[][] dungeon) {


        if (i >= m || j >= n) {
            return (int) 1e9;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            if (dungeon[i][j] >= 0) {
                return dp[i][j] = 1;
            }
            return dp[i][j] = -dungeon[i][j] + 1;
        }

        int needDown = solve(i + 1, j, dungeon);
        int needRight = solve(i, j + 1, dungeon);

        int need = Math.min(needDown, needRight) - dungeon[i][j];

        if (need <= 0) need = 1;

        return dp[i][j] = need;
    }
}