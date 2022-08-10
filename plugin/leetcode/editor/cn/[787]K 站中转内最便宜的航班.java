
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, List<int[]>> indegree = new HashMap<>();
    int src, dst;
    int[][] mem;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.src = src;
        this.dst = dst;
        k++;
        mem = new int[n][k + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -2);
        }

        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            if (!indegree.containsKey(to)) {
                indegree.put(to, new ArrayList<>());
            }
            indegree.get(to).add(new int[]{from, price});
        }

        //k步之内到达dst的最小代价
        return dp(dst, k);
    }

    // 定义：从 src 出发，k 步之内到达 s 的最短路径权重
    public int dp(int s, int k) {
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        if (mem[s][k] != -2) {
            return mem[s][k];
        }

        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                int subProblem = dp(from, k - 1);
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }

        mem[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return mem[s][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
