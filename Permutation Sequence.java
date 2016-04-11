class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    private static int f;
    private static String sub;
    public String getPermutation(int n, int k) {
        String s = "123456789";
        sub = s.substring(0, n);
        String res = "";
        f = k;
        for (int i = 0; i < n; i++) {
            res += helper();
        }
        return res;
    }
    
    public char helper() {
        int size = sub.length();
        int temp = factorial(size - 1);
        int i = (f - 1) / temp;
        char res = sub.charAt(i);
        sub = sub.substring(0, i) + sub.substring(i + 1);
        f -= i * temp;
        return res;
    }
    
    public int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
