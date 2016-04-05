public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        int x = Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);
        
        int sum = x + y;
        
        return Integer.toBinaryString(sum);
    }
}
