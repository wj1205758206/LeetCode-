
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean isBip = true;
    boolean[] color;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return isBip;
    }

    public void traverse(int[][] graph, int i){
        if (!isBip){
            return;
        }

        visited[i] = true;
        for (int v : graph[i]){
            if (!visited[v]){
                color[v] = !color[i];
                traverse(graph, v);
            }else {
                if (color[v] == color[i]){
                    isBip = false;
                    return;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
