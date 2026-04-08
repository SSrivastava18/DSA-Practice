class Solution {
    public int maxProduct(int[] nums) {
         if (nums == null || nums.length == 0) return 0;

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            int cand1 = maxEnding * n;
            int cand2 = minEnding * n;

            maxEnding = Math.max(n, Math.max(cand1, cand2));
            minEnding = Math.min(n, Math.min(cand1, cand2));

            ans = Math.max(ans, maxEnding);
        }

        return ans;
        
    }
}