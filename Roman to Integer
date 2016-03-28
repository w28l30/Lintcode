public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i >= 1 && c2n(s.charAt(i)) > c2n(s.charAt(i - 1))) {
                result += c2n(s.charAt(i)) - 2 * c2n(s.charAt(i - 1));
            } else {
                result += c2n(s.charAt(i));
            }
        }
        return result;
        
    }
    
    private int c2n(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}