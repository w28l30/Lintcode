public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int length = nums.length;
        int totalCount = 0;
        int desiredCount = length;
        
        for (int i = 0; i < length; i++) {
            totalCount += nums[i];
            desiredCount += i;
        }
        
        return desiredCount - totalCount;
    }
}
