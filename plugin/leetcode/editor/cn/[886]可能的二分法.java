
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean isBip = true;
    boolean[] visited;
    boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];

        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return isBip;
    }

    public void traverse(List<Integer>[] graph, int i) {
        if (!isBip) {
            return;
        }

        visited[i] = true;
        for (int v : graph[i]) {
            if (!visited[v]) {
                color[v] = !color[i];
                traverse(graph, v);
            } else {
                if (color[v] == color[i]) {
                    isBip = false;
                    return;
                }
            }
        }
    }

    public List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : dislikes) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        return graph;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
