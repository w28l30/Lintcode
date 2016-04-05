public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        int max = 0;
        int curLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table.isEmpty() || !table.containsKey(c)) {
                table.put(c, i);
                curLength++;
                continue;
            }
            if (curLength > max) {
                max = curLength;
            }
            int start = table.get(c);
            table.clear();
            i = start;
            curLength = 0;
        }
        if (curLength > max) {
            max = curLength;
        }
        return max;
    }
}