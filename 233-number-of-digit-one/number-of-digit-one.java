class Solution {

    Integer[][][] dp;

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        dp = new Integer[s.length()][2][s.length() + 1];
        return solve(s, 0, 1, 0);
    }

    public int solve(String n, int idx, int tight, int count) {

        if (idx == n.length()) {
            return count;
        }

        if (dp[idx][tight][count] != null) {
            return dp[idx][tight][count];
        }

        int up = (tight == 1) ? n.charAt(idx) - '0' : 9;
        int res = 0;

        for (int digit = 0; digit <= up; digit++) {

            int newTight = (tight == 1 && digit == up) ? 1 : 0;

            if (digit == 1) {
                res += solve(n, idx + 1, newTight, count + 1);
            } else {
                res += solve(n, idx + 1, newTight, count);
            }
        }

        return dp[idx][tight][count] = res;
    }
}