package tree.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍问题
 */
public class HouseRobber_III_337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        Solution solution = new HouseRobber_III_337().new Solution();
        System.out.println(solution.rob(root));
    }

    class Solution {
        /**
         * 二叉树的动态规划
         * f(o) 表示选择 o节点的情况下，o节点的子树上被选择的节点的最大权值和；
         * g(o) 表示不选择 o节点的情况下，o节点的子树上被选择的节点的最大权值和
         * l 和 r代表 o的左右孩子
         * 当 o被选中时，o的左右孩子都不能被选中   f(o) = g(l) + g(r)
         * 当 o不被选中时，o的左右孩子可以被选中，也可以不被选中 g(o)=max{f(l),g(l)}+max{f(r),g(r)}
         */
        Map<TreeNode, Integer> f = new HashMap<>();
        Map<TreeNode, Integer> g = new HashMap<>();

        public int rob(TreeNode root) {
            DFS(root);
            return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
        }

        private void DFS(TreeNode root) {
            if (root == null)
                return;
            DFS(root.left);
            DFS(root.right);
            f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
            g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                    + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
        }
    }
}
