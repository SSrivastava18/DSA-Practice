class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(0, amount, coins, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int idx, int amount, int[] coins, int[][] dp) {

        if (amount == 0) return 0;

        if (idx == coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int notTake = solve(idx + 1, amount, coins, dp);

        int take = Integer.MAX_VALUE;
        int res = solve(idx, amount - coins[idx], coins, dp);

        if (res != Integer.MAX_VALUE) {
            take = 1 + res;
        }

        return dp[idx][amount] = Math.min(notTake, take);
    }
}