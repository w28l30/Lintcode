class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices.length < 2) {
            return 0;
        }
        if (k >= prices.length) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        int n = prices.length;
        int[] global = new int[k + 1];
        int[] local = new int[k + 1];
        
        for (int i = 0; i < n - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }
};