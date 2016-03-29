public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 1 || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        
        while (true) {
            while (check(s.charAt(left))) {
                left++;
                if (left == (s.length() - 1)) {
                    break;
                }
            }
            while (check(s.charAt(right))) {
                right--;
                if (right == 0) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }
             if (s.charAt(left) != s.charAt(right) && (int) s.charAt(right) != (32 + (int)s.charAt(left)) && (int) s.charAt(left) != (32 + (int)s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public boolean check(char a) {
        if ((a >= 48 && a <= 57) || (a >= 65 && a <= 90) || (a >= 97 && a <= 122)) {
            return false;
        }
        return true;
    }
}
