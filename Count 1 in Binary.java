public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        int ones = 0;
        int count = 0;
        
        while (count < 32) {
            if ((num & 1) == 1) {
                ones++;
            }
            num = num >> 1;
            count++;
        }
        
        return ones;
    }
};
