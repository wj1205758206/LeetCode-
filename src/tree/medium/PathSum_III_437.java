package tree.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 计算路径和(任意两个节点之间的路径和等于目标值)
 */
public class PathSum_III_437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        Solution solution = new PathSum_III_437().new Solution();
        System.out.println(solution.pathSum(root, 8));

    }

    class Solution {
        /**
         * 方法一：前缀和
         * 前缀和是一个节点到root根节点之间的路径和
         * 题目要求的是找出路径和等于给定数值的路径总数，两节点间的路径和 = 两节点的前缀和之差
         */

        /*HashMap的key是前缀和， value是该前缀和的节点数量*/
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        public int pathSum(TreeNode root, int targetSum) {
            /*DFS深度优先搜索，遍历整颗树一次，记录每个节点的前缀和*/
            DFS(root, 0, targetSum);
            return sum;
        }

        private void DFS(TreeNode root, int preSum, int targetSum) {
            if (root == null)
                return;

            /*如果当前遍历的节点的前缀和之前已经出现过，就更新这个前缀和的节点个数*/
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

            /*curr记录当前节点的前缀和*/
            int curr = preSum + root.val;

            /*两节点间的路径和 = 两节点的前缀和之差
             *targetSum=prefix(cur)-prefix(x),变换一下
             * prefix(x) = prefix(cur) - targetSum
             * 也就是说，只需要判断map集合中是否存在prefix(x)这个前缀和即可
             * 如果不存在则sum加0，如果存在，在sum要加上这个前缀和对于的节点个数*/
            sum += map.getOrDefault(curr - targetSum, 0);

            /*递归遍历左右子树*/
            DFS(root.left, curr, targetSum);
            DFS(root.right, curr, targetSum);

            /*需要回溯，恢复状态
             *在遍历完一个节点的所有子节点后，将其从map中除去*/
            map.put(preSum, map.get(preSum) - 1);
        }
    }
}
