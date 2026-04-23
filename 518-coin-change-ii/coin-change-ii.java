class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return solve(0, amount, coins, dp);
    }

    public int solve(int idx, int amount, int[] coins, Integer[][] dp){

        if(amount == 0) return 1;
        if(idx == coins.length) return 0;

        if(dp[idx][amount] != null) return dp[idx][amount];

        int notTake = solve(idx + 1, amount, coins, dp);

        int take = 0;
        if(coins[idx] <= amount){
            take = solve(idx, amount - coins[idx], coins, dp);
        }

        return dp[idx][amount] = notTake + take;
    }
}