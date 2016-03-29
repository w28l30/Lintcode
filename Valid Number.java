public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0;
        while (i < s.length() && (s.charAt(i) == ' ' || s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        if (i == s.length()) {
            return false;
        }
        int j = s.length() - 1;;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        
        String element = s.substring(i, j + 1);
        i = 0;
        j = element.length() - 1;
        
        while (i <= j && Character.isDigit(element.charAt(i))) {
            i++;
        }
        if (i > j) {
            return true;
        }
        if (element.charAt(i) == ' ' || (element.charAt(i) != 'e' && element.charAt(i) != '.')) {
            return false;
        }
        if (element.charAt(i) == 'e' && i == 0 || element.charAt(i) == '.' && element.length() == 1) {
            return false;
        }
        i++;
        while (i <= j) {
            if (!Character.isDigit(element.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
