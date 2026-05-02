class Solution {
    Integer[][][][][] dp;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        long limit = (long) Math.pow(10, n) - 1;
        String s = String.valueOf(limit);

        dp = new Integer[s.length()][2][2][1 << 10][2];

        int repeated = solve(s, 0, 1, 0, 0, 1);

        return (int)(limit + 1 - repeated);
    }

    public int solve(String s, int idx, int tight, int repeated, int mask, int lz) {

        if (idx == s.length()) {
            return repeated;
        }

        if (dp[idx][tight][repeated][mask][lz] != null) {
            return dp[idx][tight][repeated][mask][lz];
        }

        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int res = 0;

        for (int d = 0; d <= ub; d++) {
            int newTight = (tight == 1 && d == ub) ? 1 : 0;

            if (lz == 1 && d == 0) {
                res += solve(s, idx + 1, newTight, repeated, mask, 1);
            } else {
                int isUsed = (mask >> d) & 1;
                int newRepeated = (repeated == 1 || isUsed == 1) ? 1 : 0;
                int newMask = mask | (1 << d);

                res += solve(s, idx + 1, newTight, newRepeated, newMask, 0);
            }
        }

        return dp[idx][tight][repeated][mask][lz] = res;
    }
}