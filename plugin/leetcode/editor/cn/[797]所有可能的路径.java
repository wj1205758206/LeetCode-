
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph.length == 0) return result;
        traverse(graph, 0); //从0节点开始遍历;
        return result;
    }

    public void traverse(int[][] graph, int i) {
        path.add(i);

        if (i == graph.length - 1) {//遍历到了最后一个节点，说明找到了一条path
            result.add(new ArrayList<>(path));
        }

        //回溯按，做选择,选择当前i节点的其中一个相邻节点
        for (int v : graph[i]) {
            traverse(graph, v);
        }

        path.remove(path.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
