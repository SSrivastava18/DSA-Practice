import java.util.Arrays;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            long x = points[i][0], y = points[i][1];
            if (y == 0) pos[i] = x;
            else if (x == side) pos[i] = side + y;
            else if (y == side) pos[i] = 2L * side + (side - x);
            else pos[i] = 3L * side + (side - y);
        }
        Arrays.sort(pos);
        
        long perimeter = 4L * side;
        int low = 1, high = side;
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(pos, k, mid, perimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(long[] pos, int k, int d, long p) {
        int n = pos.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && pos[i] >= pos[0] + d) break;
            
            int count = 1;
            long last = pos[i];
            int currentIdx = i;
            
            for (int j = 1; j < k; j++) {
                int nextIdx = lowerBound(pos, last + d, n, p);
                if (nextIdx >= i + n) {
                    count = -1;
                    break;
                }
                last = (nextIdx < n) ? pos[nextIdx] : pos[nextIdx - n] + p;
                count++;
            }
            
            if (count == k && (pos[i] + p - last) >= d) {
                return true;
            }
        }
        return false;
    }

    private int lowerBound(long[] pos, long target, int n, long p) {
        int l = 0, r = 2 * n - 1;
        int res = 2 * n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long val = (mid < n) ? pos[mid] : pos[mid - n] + p;
            if (val >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}