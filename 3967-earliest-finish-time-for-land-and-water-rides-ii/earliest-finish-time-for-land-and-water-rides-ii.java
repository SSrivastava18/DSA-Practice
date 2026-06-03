class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        final int MAX = 100000;
        final int INF = 1_000_000_000;

        int[] waterStartFinish = new int[MAX + 2]; 
        int[] waterMinDur = new int[MAX + 2];      

        java.util.Arrays.fill(waterStartFinish, INF);
        java.util.Arrays.fill(waterMinDur, INF);

        int m = waterStartTime.length;
        for (int i = 0; i < m; i++) {
            int s = waterStartTime[i];
            int d = waterDuration[i];

            waterStartFinish[s] = Math.min(waterStartFinish[s], s + d);
            waterMinDur[s] = Math.min(waterMinDur[s], d);
        }

        int[] waterSuffix = new int[MAX + 3]; 
        waterSuffix[MAX + 1] = INF;
        for (int t = MAX; t >= 1; t--) {
            waterSuffix[t] = Math.min(waterSuffix[t + 1], waterStartFinish[t]);
        }

        int[] waterPrefixDur = new int[MAX + 2]; 
        waterPrefixDur[0] = INF;
        for (int t = 1; t <= MAX; t++) {
            waterPrefixDur[t] = Math.min(waterPrefixDur[t - 1], waterMinDur[t]);
        }

        long ans = INF;

        int n = landStartTime.length;
        for (int i = 0; i < n; i++) {
            int A = landStartTime[i] + landDuration[i];

            long option1 = (A <= MAX) ? waterSuffix[A] : INF;

            int bestDurBefore;
            if (A <= 1) {
                bestDurBefore = INF;
            } else {
                bestDurBefore = waterPrefixDur[Math.min(MAX, A - 1)];
            }

            long option2 = (bestDurBefore == INF) ? INF : (long) A + bestDurBefore;

            ans = Math.min(ans, Math.min(option1, option2));
        }

        int[] landStartFinish = new int[MAX + 2]; 
        int[] landMinDur = new int[MAX + 2];   

        java.util.Arrays.fill(landStartFinish, INF);
        java.util.Arrays.fill(landMinDur, INF);

        for (int i = 0; i < n; i++) {
            int s = landStartTime[i];
            int d = landDuration[i];

            landStartFinish[s] = Math.min(landStartFinish[s], s + d);
            landMinDur[s] = Math.min(landMinDur[s], d);
        }

        int[] landSuffix = new int[MAX + 3];
        landSuffix[MAX + 1] = INF;
        for (int t = MAX; t >= 1; t--) {
            landSuffix[t] = Math.min(landSuffix[t + 1], landStartFinish[t]);
        }

        int[] landPrefixDur = new int[MAX + 2];
        landPrefixDur[0] = INF;
        for (int t = 1; t <= MAX; t++) {
            landPrefixDur[t] = Math.min(landPrefixDur[t - 1], landMinDur[t]);
        }

        for (int j = 0; j < m; j++) {
            int B = waterStartTime[j] + waterDuration[j];

            long option1 = (B <= MAX) ? landSuffix[B] : INF;

            int bestDurBefore;
            if (B <= 1) {
                bestDurBefore = INF;
            } else {
                bestDurBefore = landPrefixDur[Math.min(MAX, B - 1)];
            }

            long option2 = (bestDurBefore == INF) ? INF : (long) B + bestDurBefore;

            ans = Math.min(ans, Math.min(option1, option2));
        }

        return (int) ans;
    }
}