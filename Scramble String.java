public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        if (s1.length() == 1 && s1.equals(s2)) {
            return true;
        }
        int length = s1.length();
        for (int i = 1; i <= length - 1; i++) {
            String left1 = s1.substring(0, i);
            String left2 = s2.substring(0, i);
            String right1 = s1.substring(i);
            String right2 = s2.substring(i);
            String right3 = s2.substring(0, length - i);
            String right4 = s2.substring(length - i);
            if (isSortedEqual(left1, left2) && isSortedEqual(right1, right2)) {
                return true;
            }
            if (isSortedEqual(left1, right4) && isSortedEqual(right1, right3)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isSortedEqual(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String sorted1 = String.valueOf(arr1);
        String sorted2 = String.valueOf(arr2);
        if (sorted1.equals(sorted2)) {
            return true;
        }
        return false;
    }
}