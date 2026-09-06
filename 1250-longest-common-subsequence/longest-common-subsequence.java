class Solution {
    public static int n1;
    public static int n2;
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();

        int[][] dp  = new int[n1+1][n2+1]; 
        for(int i = 0; i<=n1; i++){
            for(int j = 0; j<=n2; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, text1, text2,dp);
    }

    public int solve(int i, int j, String text1, String text2, int[][] dp) {

        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if(dp[i][j] != -1 ){
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + solve(i + 1, j + 1, text1, text2,dp);
        }

        int skipText1 = solve(i + 1, j, text1, text2,dp);
        int skipText2 = solve(i, j + 1, text1, text2,dp);

        dp[i][j] =  Math.max(skipText1, skipText2);
        return dp[i][j];
    }
}