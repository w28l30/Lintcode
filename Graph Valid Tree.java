public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        if (n == 1) {
            return true;
        }
        if (edges == null || edges.length == 0 || n <= 0) {
            return false;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < edges.length; i++) {
            if (map.get(edges[i][0]) == null) {
                map.put(edges[i][0], true);
            }
            if (map.get(edges[i][1]) == null) {
                map.put(edges[i][1], true);
            }
            int x = find(parent, edges[i][0]);
            int y = find(parent, edges[i][1]);
            if (x == y) {
                return false;
            }
            union(parent, x, y);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(i) == null) {
                return false;
            }
        }
        return true;
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
    
    public void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }
}