/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        
        if (intervals.size() == 1) {
            result.add(intervals.get(0));
            return result;
        }
        
        Collections.sort(intervals, new intervalsComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (end >= intervals.get(i + 1).end) {
                continue;
            } else if (end >= intervals.get(i + 1).start) {
                end = intervals.get(i + 1).end;
            } else {
                Interval item = new Interval(start, end);
                result.add(item);
                start = intervals.get(i + 1).start;
                end = intervals.get(i + 1).end;
            }
        }
        
        Interval item = new Interval(start, end);
        result.add(item);
        
        return result;
    }
    
    class intervalsComparator implements Comparator<Interval> {
        public int compare(Interval x, Interval y) {
            return x.start - y.start;
        }
    }

}
