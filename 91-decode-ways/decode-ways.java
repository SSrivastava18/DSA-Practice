class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);   
        return decode(s, 0, memo);
    }

    private int decode(String s, int index, int[] memo) {

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int ways = decode(s, index + 1, memo);

        if (index + 1 < s.length()) {
            int num = (s.charAt(index) - '0') * 10
                    + (s.charAt(index + 1) - '0');

            if (num >= 10 && num <= 26) {
                ways += decode(s, index + 2, memo);
            }
        }

        memo[index] = ways;
        return ways;
    }
}