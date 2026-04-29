class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, h, piles)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }

        return ans;
    }

    public static boolean isPossible(int mid, int h, int[] piles) {
        long totalHours = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHours += (piles[i]+mid-1) / mid;
        }

        return totalHours <= h;
    }
}