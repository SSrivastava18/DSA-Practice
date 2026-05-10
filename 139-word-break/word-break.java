class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        
        Arrays.fill(dp, -1);
        
        return solve(0, s, wordDict, dp);
    }

    public boolean solve(int idx, String s, List<String> wordDict, int[] dp) {

        if (idx == s.length()) {
            return true;
        }

        if (dp[idx] != -1) {
            return dp[idx] == 1;
        }

        for (int i = 0; i < wordDict.size(); i++) {

            String word = wordDict.get(i);

            if (idx + word.length() <= s.length() &&
                s.substring(idx, idx + word.length()).equals(word)) {

                if (solve(idx + word.length(), s, wordDict, dp)) {
                    
                    dp[idx] = 1;
                    return true;
                }
            }
        }

        dp[idx] = 0;
        return false;
    }
}