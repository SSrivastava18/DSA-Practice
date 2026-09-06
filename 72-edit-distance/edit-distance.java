class Solution {
    public int minDistance(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int[][] dp = new int[w1+1][w2+1];
        for(int i = 1; i<=w1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j<=w2; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i<=w1; i++){
            for(int j=1; j<=w2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int tl = dp[i-1][j-1];
                    int t = dp[i-1][j];
                    int l = dp[i][j-1];
                    dp[i][j] = 1+Math.min(tl, Math.min(t,l));
                }
            }
        }
        return dp[w1][w2];
    }
}