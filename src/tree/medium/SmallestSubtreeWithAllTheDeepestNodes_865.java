package tree.medium;

/**
 * 具有所有最深节点的最小子树
 */
public class SmallestSubtreeWithAllTheDeepestNodes_865 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution solution = new SmallestSubtreeWithAllTheDeepestNodes_865().new Solution();
        System.out.println(solution.subtreeWithAllDeepest(root).val);
    }

    class Solution {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null)
                return null;
            /*比较左右子树高度，如果左右子树高度相等则返回root节点*/
            if (maxDepth(root.left) == maxDepth(root.right))
                return root;
            /*向高度较高的子树进行递归遍历*/
            if (maxDepth(root.left) > maxDepth(root.right))
                return subtreeWithAllDeepest(root.left);
            return subtreeWithAllDeepest(root.right);
        }

        private int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
