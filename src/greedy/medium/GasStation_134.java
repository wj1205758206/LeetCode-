package greedy.medium;

/**
 * 加油站
 */
public class GasStation_134 {
    public static void main(String[] args) {
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};

        Solution solution = new GasStation_134().new Solution();
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;

            for (int start = 0; start < n; start++) {
                int tank = 0;
                for (int step = 0; step <= n; step++) {
                    int i = (start + step) % n;
                    tank += gas[i];
                    tank -= cost[i];
                    if (tank < 0) {
                        break;
                    }

                }
                if (tank >= 0)
                    return start;

            }
            return -1;
        }
    }
}
