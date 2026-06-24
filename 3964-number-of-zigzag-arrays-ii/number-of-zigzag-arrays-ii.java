class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        int sz = 2 * m;
        long[] base = new long[sz];

        for (int j = 0; j < m; j++) {
            base[j] = j;               
            base[m + j] = m - 1 - j;  
        }

        long[][] T = new long[sz][sz];

        // U' = A * D
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < j; i++) {
                T[j][m + i] = 1;
            }
        }

        // D' = B * U
        for (int j = 0; j < m; j++) {
            for (int i = j + 1; i < m; i++) {
                T[m + j][i] = 1;
            }
        }

        long[] res = powerApply(T, n - 2, base);

        long ans = 0;
        for (long x : res) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] powerApply(long[][] mat, long exp, long[] vec) {
        int n = mat.length;

        long[][] cur = mat;
        long[] res = vec.clone();

        boolean first = true;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                if (first) {
                    res = multiply(cur, res);
                    first = false;
                } else {
                    res = multiply(cur, res);
                }
            }

            exp >>= 1;
            if (exp > 0) {
                cur = multiply(cur, cur);
            }
        }

        return res;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    sum = (sum + mat[i][j] * vec[j]) % MOD;
                }
            }
            res[i] = sum;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                long aik = a[i][k];
                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + aik * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}