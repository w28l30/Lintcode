public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int side = heights[i] < heights[j] ? heights[i] : heights[j];
                int area = side * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
}
