class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;   
        int right = 1;  
        int maxdiff = 0;

        while (right < prices.length) {

            if (prices[right] > prices[left]) {
                int currdiff = prices[right] - prices[left];
                if (currdiff > maxdiff) {
                    maxdiff = currdiff;
                }
            } 
            else {
                left = right;
            }

            right++;
        }

        return maxdiff;
    }
}