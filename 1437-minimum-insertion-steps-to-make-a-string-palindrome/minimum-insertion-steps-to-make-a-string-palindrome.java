class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        return n - longestPalindromeSubseq(s);

        
    }
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(n, n, s1, s2, dp);
    }

    private int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + solve(i - 1, j - 1, s1, s2, dp);
        } else {
            dp[i][j] = Math.max(
                solve(i - 1, j, s1, s2, dp),
                solve(i, j - 1, s1, s2, dp)
            );
        }
        return dp[i][j];
    }
}