class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights == null || heights.length ==0 || heights[0].length ==0) {
            return ans;
        }
        int m =heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int j=0;j<n;j++){
            dfs(0,j, pacific, heights, Integer.MIN_VALUE);

            dfs(m-1, j,atlantic,heights, Integer.MIN_VALUE);
        }

        for(int i=0;i<m;i++){

            dfs(i,0, pacific, heights, Integer.MIN_VALUE);

            dfs(i, n-1,atlantic,heights, Integer.MIN_VALUE);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);
                    ans.add(indexes);
                }
            }
        }
        return ans;

    }


    private void dfs(int i, int j, boolean[][] canReach, int[][] heights, int prevHeight){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || canReach[i][j] || heights[i][j] <prevHeight){
            return ;
        }

        canReach[i][j] = true;

        dfs(i+1, j, canReach, heights, heights[i][j]);
        dfs(i-1, j, canReach, heights, heights[i][j]);
        dfs(i, j-1, canReach, heights, heights[i][j]);
        dfs(i, j+1, canReach, heights, heights[i][j]);

        
    }
}