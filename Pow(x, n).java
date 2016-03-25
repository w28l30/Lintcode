public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        double result;
        int absN = Math.abs(n);
        if (n % 2 == 0) {
            result = myPowHelper(x, absN);
        } else {
            result = myPowHelper(x, absN - 1) * x;
        }
        return n > 0 ? result : 1 / result;
    }
    
    public double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double square = x * x;
        return myPowHelper(square, n/2);
        
    }
}