public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
     
    private class Edge {
        private boolean isLeft;
        private int x;
        private int height;
        
        public Edge(int x, boolean isLeft, int height) {
            this.x = x;
            this.height = height; 
            this.isLeft = isLeft;
        }
    }
    
    public class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge a, Edge b) {
            if (a.x != b.x) {
                return a.x - b.x;
            }
            if (a.isLeft && b.isLeft) {
                return b.height - a.height;
            }
            if (!a.isLeft && !b.isLeft) {
                return a.height - b.height;
            }
            return a.isLeft ? -1 : 1;
        }
    }
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        ArrayList<Edge> edges = new ArrayList<Edge>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10000, Collections.reverseOrder());
        for(int i = 0; i < buildings.length; i++) {
            Edge left = new Edge(buildings[i][0], true, buildings[i][2]);
            Edge right = new Edge(buildings[i][1], false, buildings[i][2]);
            edges.add(left);
            edges.add(right);
        }
        Collections.sort(edges, new EdgeComparator());
        
        for (Edge e : edges) {
            if (e.isLeft) {
                if (pq.isEmpty() || e.height > pq.peek()) {
                    ArrayList<Integer> elem = new ArrayList<Integer>();
                    elem.add(e.x);
                    elem.add(e.height);
                    res.add(elem);
                }
                pq.add(e.height);
            } else {
                pq.remove(e.height);
                if (pq.isEmpty()) {
                    ArrayList<Integer> elem = new ArrayList<Integer>();
                    elem.add(e.x);
                    elem.add(0);
                    res.add(elem);
                } else if (e.height > pq.peek()) {
                    ArrayList<Integer> elem = new ArrayList<Integer>();
                    elem.add(e.x);
                    elem.add(pq.peek());
                    res.add(elem);
                }
            }
        }
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).get(1) == 0) {
                res.remove(i);
            }
            res.get(i).add(res.get(i + 1).get(0));
            int temp = res.get(i).get(1);
            res.get(i).set(1, res.get(i).get(2));
            res.get(i).set(2, temp);
        }
        res.remove(res.size() - 1);
        return res;
    }
}