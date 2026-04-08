class Solution {

    int MOD = 1000000007;
    int[][][] dp;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;

        dp = new int[len][n + 1][minProfit + 1];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, 0, n, minProfit, group, profit);
    }

    public int solve(int i, int members, int currProfit,
                     int n, int minProfit, int[] group, int[] profit) {

        // cap profit
        currProfit = Math.min(currProfit, minProfit);

        if (i == group.length) {
            return currProfit >= minProfit ? 1 : 0;
        }

        if (dp[i][members][currProfit] != -1) {
            return dp[i][members][currProfit];
        }

        // not take
        int notTake = solve(i + 1, members, currProfit, n, minProfit, group, profit);

        // take
        int take = 0;
        if (members + group[i] <= n) {
            take = solve(i + 1,
                         members + group[i],
                         currProfit + profit[i],
                         n, minProfit, group, profit);
        }

        return dp[i][members][currProfit] = (take + notTake) % MOD;
    }
}