public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if (divisor == 0) {
            return 2147483647;
        }
        
  
        
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        
        if (dividend == -2147483648 && divisor == 1) {
            return -2147483648;
        }

        int quotient = 0;
        int flag = 0;
        
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = 1;
        }
        
        dividend = (dividend < 0 ? dividend : 0 - dividend);
        divisor = (divisor < 0 ? divisor : 0 - divisor);
        
        while (dividend <= divisor) {
            dividend -= divisor;
            quotient++;
        }
        
        if (flag == 1) {
            quotient = 0 - quotient;
        }
        
        return quotient;
    }
}
