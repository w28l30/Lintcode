public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null) {
            return 0;
        }
        String[] strArr = s.split(" ");
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i] != " ") {
                return strArr[i].length();
            }
        }
        return 0;
    }
}
