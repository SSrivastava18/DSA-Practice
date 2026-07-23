class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((long)m * k > n) return -1;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            start = Math.min(start, day);
            end = Math.max(end, day);
        }

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0; 
            }
        }

        return bouquets >= m;
    }
}