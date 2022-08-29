
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] nodeNum; //子树个数（包括自己）
    int[] distSum; //距离和

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        buildGraph(n, edges);
        nodeNum = new int[n];
        distSum = new int[n];
        Arrays.fill(nodeNum, 1);

        postOrder(0, -1);
        preOrder(0, -1);

        return distSum;
    }

    //求root到子树所有节点的距离和
    public void postOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for (int neighbor : neighbors) {
            if (neighbor == parent) {
                continue;
            }
            postOrder(neighbor, root);
            nodeNum[root] += nodeNum[neighbor];
            distSum[root] += distSum[neighbor] + nodeNum[neighbor];
        }
    }

    //根据root计算其邻居到所在子树之外的节点的距离和（包括root节点）
    public void preOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for (int neighbor : neighbors) {
            if (neighbor == parent) {
                continue;
            }
            distSum[neighbor] = distSum[root] - nodeNum[neighbor] + (graph.size() - nodeNum[neighbor]);
            preOrder(neighbor, root);
        }
    }

    public void buildGraph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
