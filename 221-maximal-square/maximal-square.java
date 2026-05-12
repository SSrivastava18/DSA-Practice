class Solution {

    int n;
    int m;
    int maxSide = 0;
    int[][] dp;

    public int maximalSquare(char[][] matrix) {
       

        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=m; j++){
                dp[i][j] = -1;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                solve(i, j, matrix);
            }
        }

        return maxSide * maxSide;
    }

    public int solve(int i, int j, char[][] matrix) {

        if (i >= n || j >= m) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down = solve(i + 1, j, matrix);

        int right = solve(i, j + 1, matrix);

        int diagonal = solve(i + 1, j + 1, matrix);

        if (matrix[i][j] == '1') {

            int side = 1 + Math.min(down,
                        Math.min(right, diagonal));

            maxSide = Math.max(maxSide, side);

            return dp[i][j] =  side;
        }

        return dp[i][j] =  0;
    }
}