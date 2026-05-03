class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int Totalscore = 0;
        for(int i = 0; i<n; i++){
            Totalscore += nums[i];
        }
        int player1 = solve(0,n-1, nums);
        int player2 = Totalscore - player1;

        return player1 >= player2;
        
    }
    public static int solve(int i,  int j, int[] nums){
        if(i>j){
            return 0;
        }
        if(i == j){
            return nums[i];
        }
        int take_i = nums[i] + Math.min(solve(i+2,j,nums), solve(i+1,j-1,nums));
        int take_j = nums[j] + Math.min(solve(i+1,j-1,nums), solve(i,j-2,nums));

        return Math.max(take_i, take_j);

    }
}