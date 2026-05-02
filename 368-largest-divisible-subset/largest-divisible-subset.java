class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int lastIdx = 0;

        for (int curr = 1; curr < n; curr++) {
            for (int prev = 0; prev < curr; prev++) {
                if (nums[curr] % nums[prev] == 0 && dp[curr] < dp[prev] + 1) {
                    dp[curr] = dp[prev] + 1;
                    parent[curr] = prev;
                }
            }

            if (dp[curr] > maxLen) {
                maxLen = dp[curr];
                lastIdx = curr;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = lastIdx; i != -1; i = parent[i]) {
            ans.add(nums[i]);
        }

        Collections.reverse(ans);
        return ans;
    }
}