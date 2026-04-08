class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 1, n, prices, k, dp);
    }

    public int solve(int idx, int buy, int n, int[] prices, int k, int[][][] dp) {

        if (idx == n || k == 0) return 0;

        if (dp[idx][buy][k] != -1) {
            return dp[idx][buy][k];
        }

        int profit;
        if (buy == 1) {
            profit = Math.max(
                -prices[idx] + solve(idx + 1, 0, n, prices, k, dp),
                solve(idx + 1, 1, n, prices, k, dp)
            );
        } else {
            profit = Math.max(
                prices[idx] + solve(idx + 1, 1, n, prices, k - 1, dp),
                solve(idx + 1, 0, n, prices, k, dp)
            );
        }

        return dp[idx][buy][k] = profit;
    }
}