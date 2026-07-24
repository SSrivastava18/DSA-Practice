class Solution {
    public int uniqueXorTriplets(int[] nums) {

        final int MAX = 2048;

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        for (int val : nums) {

            boolean[][] next = new boolean[4][MAX];

            for (int c = 0; c <= 3; c++) {
                System.arraycopy(dp[c], 0, next[c], 0, MAX);
            }

            for (int cnt = 0; cnt <= 3; cnt++) {

                for (int xr = 0; xr < MAX; xr++) {

                    if (!dp[cnt][xr]) continue;

                    if (cnt + 1 <= 3)
                        next[cnt + 1][xr ^ val] = true;

                    if (cnt + 2 <= 3)
                        next[cnt + 2][xr] = true;

                    if (cnt + 3 <= 3)
                        next[cnt + 3][xr ^ val] = true;
                }
            }

            dp = next;
        }

        int ans = 0;
        for (boolean possible : dp[3]) {
            if (possible) ans++;
        }

        return ans;
    }
}