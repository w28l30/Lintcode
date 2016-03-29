public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int curSum = 0;
        int end = 0;
        int n = nums.length;
        int start = 0;
        int minLength = nums.length + 1;
        while (end < n) {
            while (curSum < s && end < n) {
                curSum += nums[end++];
            }
            
            while (curSum >= s && start < n) {
                int length = end - start;
                if (length < minLength) {
                    minLength = length;
                }
                curSum = curSum - nums[start++];
            }
        }
        if (start == 0 && end == n && curSum < s) {
            return -1;
        }
        return minLength;
    }
}
