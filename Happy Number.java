public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        HashSet<Integer> hash = new HashSet<Integer>();
        
        int num = n;
        while (num != 1) {
            int sum = 0;
            
            while (num != 0) {
                int remainder = num % 10;
                sum += Math.pow(remainder, 2);
                num = num / 10;
            }
            num = sum;
            if (hash.contains(num)) {
                return false;
            }
            hash.add(num);
        }
        
        return true;
    }
}