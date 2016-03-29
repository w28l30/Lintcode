public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        StringBuilder s = new StringBuilder();
        int count;
        s.append("1");
        if (n == 1) {
            return s.toString();
        }

        for (int i = 2; i <= n; i++) {
            count = 1;
            StringBuilder result = new StringBuilder();
            int j = 1;
            for (; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    result.append(count);
                    result.append(s.charAt(j-1));
                    count = 1;
                }
            }
            // last element
            if (j == 1 || (s.charAt(j - 1) == s.charAt(j - 2))) {
                result.append(count);
                result.append(s.charAt(j - 1));
            } else {
                result.append(1);
                result.append(s.charAt(j - 1));
            }
            s = result;
        }
        
        return s.toString();
    }
}
