class Solution {

    static int[][] dp;
    static int[] startTimes;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

        startTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startTimes[i] = events[i][0];
        }

        dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(events, 0, k);
    }

    private int solve(int[][] events, int i, int k) {
        if (i >= events.length || k == 0) return 0;

        if (dp[i][k] != -1) return dp[i][k];

        int skip = solve(events, i + 1, k);

        int next = findNext(events[i][1]);

        int take = events[i][2] + solve(events, next, k - 1);

        return dp[i][k] = Math.max(skip, take);
    }

    private int findNext(int endTime) {
        int left = 0, right = startTimes.length - 1;
        int ans = startTimes.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (startTimes[mid] > endTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}