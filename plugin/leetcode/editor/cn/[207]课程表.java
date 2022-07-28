
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 记录一次递归堆栈中的节点,当前递归的路径
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路，全局的记录，需要以每个节点为起点进行DFS
    boolean[] visited;
    // 记录是否有环
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //根据节点个数和关系，建图(邻接表)
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //以每个节点为起点，开始DFS
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>(); //数组中每一个索引位置，都挂一条链表，这样就形成了邻接表
        }
        for (int[] edge : prerequisites) { //选课顺序，实际上就是 边
            int from = edge[1], to = edge[0];
            // 添加一条从 from 指向 to 的有向边
            // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
            graph[from].add(to);
        }
        return graph;
    }

    public void traverse(List<Integer>[] graph, int i) {
        if (onPath[i]){
            hasCycle = true; //当前路径如果已经访问过了，也就是首尾互相连了，这说明出现了环
        }

        if (visited[i] || hasCycle){
            return; //如果以当前节点i为起点了DFS已经访问过了，防弊走回头路，就没必要DFS了，或者出现了环也没必要继续了
        }

        //visited主要来控制主函数中的for循环
        visited[i] = true;

        //回溯
        //onPath主要来控制当前DFS
        onPath[i] = true;
        for (int t : graph[i]){
            traverse(graph, t);
        }
        onPath[i] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
