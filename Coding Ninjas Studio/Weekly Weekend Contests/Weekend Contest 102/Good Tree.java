import java.util.*;

public class Solution {
    static int goodTree(int n, int[] color, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == 3) {
                boolean found1 = false, found2 = false;

                List<Integer> neighbors = graph.getOrDefault(i + 1, new ArrayList<>());
                for (int neighbor : neighbors) {
                    if (color[neighbor - 1] == 1) {
                        found1 = true;
                    } else if (color[neighbor - 1] == 2) {
                        found2 = true;
                    }
                }

                if (!found1 || !found2) {
                    return 0;
                }
            }
        }

        return 1;
    }
}