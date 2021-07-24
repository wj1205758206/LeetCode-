package tree.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断二叉树所有的节点值是否都一样
 */
public class UnivaluedBinaryTree_965 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);

        Solution solution = new UnivaluedBinaryTree_965().new Solution();
        System.out.println(solution.isUnivalTree(root));

    }

    class Solution {
        /**
         * 方法一：
         * 先序遍历所有二叉树节点，并保存到map集合中
         * 如果map集合大小为1，那么说明所有节点值都一样
         */
        Map<Integer, Integer> map = new HashMap<>();

        public boolean isUnivalTree(TreeNode root) {
            preOrder(root);
            return map.size() == 1;
        }

        private void preOrder(TreeNode root) {
            if (root == null)
                return;
            if (!map.containsKey(root.val))
                map.put(root.val, root.val);
            preOrder(root.left);
            preOrder(root.right);
        }

        /**
         * 方法二：
         * 以root根节点值val为标准，递归判断当前root节点值是否等于val
         * 当root的值等于val并且root的左右孩子也等于val才返回true
         *
         * @param root
         * @return
         */
        public boolean isUnivalTree2(TreeNode root) {
            return isSameValue(root, root.val);
        }

        private boolean isSameValue(TreeNode root, int val) {
            if (root == null)
                return true;
            return root.val == val && isSameValue(root.left, val) && isSameValue(root.right, val);
        }

    }
}
