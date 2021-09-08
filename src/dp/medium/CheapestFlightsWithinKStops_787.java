package dp.medium;

import java.util.*;

/**
 * K站中转内最便宜的航班(指定边数求最短路径)
 */
public class CheapestFlightsWithinKStops_787 {
    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        Solution solution = new CheapestFlightsWithinKStops_787().new Solution();
        System.out.println(solution.findCheapestPrice(3, flights, 0, 2, 1));
    }

    class Solution {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[][] memory;

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            /*我们需要备忘录记录多个节点入度是同一个节点的情况*/
            memory = new int[n][k + 1 + 1];
            for (int[] row : memory) {
                Arrays.fill(row, -2);
            }

            /*使用map保存每个节点的入度信息，from和price*/
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                map.putIfAbsent(to, new LinkedList<>());
                map.get(to).add(new int[]{from, price});
            }

            /*dp定义为
             * 从src开始，经过k步，到某个节点的最短路径
             * 那么我们所要求得就是src经过k+1,到达dst最短路径是多少*/
            return dp(src, dst, k + 1);
        }

        private int dp(int src, int dst, int k) {
            if (src == dst)
                return 0;
            if (k == 0)
                return -1;

            if (memory[dst][k] != -2)
                return memory[dst][k];

            int result = Integer.MAX_VALUE;

            /*遍历所有的入度*/
            if (map.containsKey(dst)) {
                for (int[] indegree : map.get(dst)) {
                    int from = indegree[0];
                    int price = indegree[1];
                    /*计算子问题*/
                    int subProblem = dp(src, from, k - 1);
                    /*如果有界，子问题结果再加上price，就是当前选择的节点到达目标节点的最短路径
                     * 遍历所有入度节点，取最小值*/
                    if (subProblem != -1)
                        result = Math.min(result, subProblem + price);
                }
            }
            memory[dst][k] = result == Integer.MAX_VALUE ? -1 : result;
            return memory[dst][k];
        }
    }
}
