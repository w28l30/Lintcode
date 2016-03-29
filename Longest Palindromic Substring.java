public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int size = s.length();
        int max = 0;
        int left = 0;
        int right = 0;
        boolean[][] isPal = new boolean[size][size];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i; j < size; j++) {
                if ((i + 1 > j - 1 || isPal[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    isPal[i][j] = true;
                    if (j - i + 1 > max) {
                        left = i;
                        right = j;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}