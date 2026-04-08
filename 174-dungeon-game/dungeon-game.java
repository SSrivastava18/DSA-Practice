class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1) {

                    if (dungeon[i][j] >= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = -dungeon[i][j] + 1;
                    }
                }

                else if (i == m - 1) {
                    int needRight = dp[i][j + 1] - dungeon[i][j];
                    if (needRight <= 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = needRight;
                    }
                }

                else if (j == n - 1) {
                    int needDown = dp[i + 1][j] - dungeon[i][j];
                    if (needDown <= 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = needDown;
                    }
                }

                else {
                    int next = dp[i + 1][j];
                    if (dp[i][j + 1] < next) {
                        next = dp[i][j + 1];
                    }

                    int need = next - dungeon[i][j];

                    if (need <= 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = need;
                    }
                }
            }
        }

        return dp[0][0];
    }
}