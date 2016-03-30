class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    static int[] fib = new int [100];
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (fib[n] != 0) {
            return fib[n];
        }
        fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return fib[n];
    }
}


