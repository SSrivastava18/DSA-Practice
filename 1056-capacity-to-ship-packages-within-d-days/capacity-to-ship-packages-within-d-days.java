class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > left) {
                left = weights[i];
            }

        }
        for (int i = 0; i < weights.length; i++) {
            right += weights[i];
        }
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (possible(weights, mid, days)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }

    public static boolean possible(int[] weights, int cap, int days) {
        int currDays = 1;
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] <= cap) {
                sum += weights[i];
            } else {
                currDays++;
                sum = weights[i];
            }
        }

        return currDays <= days;
    }
}