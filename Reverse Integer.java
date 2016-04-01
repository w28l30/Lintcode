public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        if (n == 0) {
            return 0;
        }
        boolean isNegative = false;
        
        if (n < 0) {
            isNegative = true;
            n = -n;
        }
        StringBuilder i = new StringBuilder();
        
        int remainder = 0;
        int digit = 10;
        int result = 0;
        
        while (n > 0) {
            remainder = n % 10;
            if (result > 214748364 && remainder > 7) {
                return 0;
            }
            result = result * digit + remainder;
            n = n / 10;
        }
        
        return isNegative == false ? result : -result;
    }
}
