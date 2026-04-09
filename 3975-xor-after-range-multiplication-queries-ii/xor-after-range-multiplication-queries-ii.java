class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        int BLOCK = (int) Math.sqrt(n) + 1;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        @SuppressWarnings("unchecked")
        java.util.HashMap<Integer, Long>[] lazy = new java.util.HashMap[BLOCK + 1];
        for (int k = 1; k <= BLOCK; k++) lazy[k] = new java.util.HashMap<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            long v = q[3];

            if (k <= BLOCK) {
                lazy[k].merge(l, v, (a, b) -> a * b % MOD);
                int last = r - ((r - l) % k);
                int next = last + k;
                if (next <= n) {
                    long inv = modPow(v, MOD - 2, MOD);
                    lazy[k].merge(next, inv, (a, b) -> a * b % MOD);
                }
            } else {
                for (int idx = l; idx <= r; idx += k) {
                    arr[idx] = arr[idx] * v % MOD;
                }
            }
        }

        for (int k = 1; k <= BLOCK; k++) {
            if (lazy[k].isEmpty()) continue;
            for (int rem = 0; rem < k; rem++) {
                long mul = 1L;
                for (int i = rem; i < n; i += k) {
                    Long val = lazy[k].get(i);
                    if (val != null) mul = mul * val % MOD;
                    if (mul != 1L) arr[i] = arr[i] * mul % MOD;
                }
            }
        }

        long xor = 0;
        for (long val : arr) xor ^= val;
        return (int) xor;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}