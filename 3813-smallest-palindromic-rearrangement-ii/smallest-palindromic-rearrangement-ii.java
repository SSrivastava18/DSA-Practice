class Solution {

    private static final long LIMIT = 1_000_001;

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        char mid = 0;
        int[] half = new int[26];
        int len = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);

            half[i] = freq[i] / 2;
            len += half[i];
        }

        StringBuilder left = new StringBuilder();

        while (len > 0) {

            boolean found = false;

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long cnt = countWays(half);

                if (cnt >= k) {
                    left.append((char) ('a' + c));
                    len--;
                    found = true;
                    break;
                }

                k -= cnt;
                half[c]++;
            }

            if (!found)
                return "";
        }

        StringBuilder ans = new StringBuilder(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] cnt) {

        int total = 0;

        for (int x : cnt)
            total += x;

        long ans = 1;

        int rem = total;

        for (int x : cnt) {

            if (x == 0)
                continue;

            ans *= comb(rem, x);

            if (ans > LIMIT)
                ans = LIMIT;

            rem -= x;
        }

        return ans;
    }

    private long comb(int n, int r) {

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - r + i) / i;

            if (ans > LIMIT)
                return LIMIT;
        }

        return ans;
    }
}