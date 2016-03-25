/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        int max = 0;
        if (points == null || points.length == 0) {
            return max;
        }
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            map.put((double) Integer.MIN_VALUE, 1);
            int duplicate = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                    continue;
                }
                double k = points[i].x == points[j].x ? Integer.MAX_VALUE : 0.0 + (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
            }
            for (int temp : map.values()) {
                if (temp + duplicate > max) {
                    max = temp + duplicate;
                }
            }
        }
        return max;
    }
}
