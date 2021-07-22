package tree.easy;

/**
 * 合并两棵二叉树
 */
public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);

        Solution solution = new MergeTwoBinaryTrees_617().new Solution();
        TreeNode newNode = solution.mergeTrees(root1, root2);
        System.out.println(newNode.left.right.val);
    }

    class Solution {
        /*合并两颗二叉树
         * 当前遍历的两个节点都不为null时，创建一个新的节点，值为这两个节点值之和
         * 当前遍历的两个节点都为null时，直接返回null
         * 当前遍历的两个节点其中有一个为null时，返回不为null的那个节点，使其充当合并后的新二叉树的左子树或者右子树*/
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return null;
            if (root1 != null && root2 == null)
                return root1;
            if (root1 == null && root2 != null)
                return root2;
            TreeNode newNode = new TreeNode(root1.val + root2.val);
            newNode.left = mergeTrees(root1.left, root2.left);
            newNode.right = mergeTrees(root1.right, root2.right);
            return newNode;
        }
    }
}
