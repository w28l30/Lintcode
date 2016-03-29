public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = -1;
        int j = nums.length;
        int lo = i + 1;
        int hi = j - 1;
        
        while (true) {
            while ((nums[++i] % 2) == 1) {
                if (i == hi) {
                    break;
                }
            }
            while ((nums[--j] % 2) == 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
    }
    
    public void exch(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
